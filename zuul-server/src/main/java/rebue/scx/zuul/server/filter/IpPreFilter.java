package rebue.scx.zuul.server.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import lombok.extern.slf4j.Slf4j;
import rebue.scx.zuul.server.co.ZuulCo;
import rebue.wheel.AgentUtils;
import rebue.wheel.RegexUtils;

/**
 * IP过滤器
 * 1. 获取浏览器客户端IP
 * 2. 模拟Nginx在请求头中加入X-Real-IP，后面微服务可就此取得实际的用户IP
 * 3. 判断是否匹配IP黑名单，遇到名单中的ip直接中断
 *
 */
@Slf4j
@Component
//让yml配置文件中的List类的节点自动注入本bean中相应的属性(注意如果配置文件里是小驼峰命名，这里却要对应写成小写并下划线隔开的规则)
@ConfigurationProperties(prefix = "zuul.filter.ip-pre-filter")
public class IpPreFilter extends ZuulFilter {

    @Value("${zuul.filter.ipPreFilter.shouldFilter:true}")
    private Boolean      shouldFilter;
    @Value("${zuul.filter.ipPreFilter.filterOrder:1}")
    private Integer      filterOrder;
    /**
     * 经过的反向代理(noproxy/nginx/apache/weblogic，默认noproxy没有经过代理)
     */
    @Value("${zuul.passProxy:noproxy}")
    private String       passProxy;
    /**
     * IP黑名单(遇到名单中的ip直接中断)
     * (读取yml配置文件中的对应属性)
     */
    private List<String> ipBlackList;

    public List<String> getIpBlackList() {
        return ipBlackList;
    }

    public void setIpBlackList(final List<String> ipBlackList) {
        this.ipBlackList = ipBlackList;
    }

    @Override
    public String filterType() {
        log.info("设置IpPreFilter的过滤器类型为pre");
        return "pre";
    }

    @Override
    public int filterOrder() {
        log.info("设置IpPreFilter的排序号为{}(数字越大，优先级越高)", filterOrder);
        return filterOrder;
    }

    @Override
    public boolean shouldFilter() {
        log.info("设置是否需要执行IpPreFilter过滤器: {}", shouldFilter);
        return shouldFilter;
    }

    @Override
    public Object run() {
        log.info("\r\n============================= 运行IpPreFilter过滤器 =============================\r\n");
        try {
            final RequestContext ctx = RequestContext.getCurrentContext();
            final HttpServletRequest req = ctx.getRequest();
            final String url = req.getMethod() + ":" + req.getRequestURI();
            log.debug("处理请求的URL：{}", url);
            // 获取浏览器客户端IP
            final String agentIp = AgentUtils.getIpAddr(req, passProxy);
            // 是否局域网IP
            final boolean isLanIp = RegexUtils.matchIpv4OfLan(agentIp);
            log.info("获取到浏览器客户端IP: {}，是来自{}的IP", agentIp, isLanIp ? "局域网" : "公网");
            log.info("将浏览器客户端IP加入到ctx中传递给其它过滤器");
            ctx.set(ZuulCo.AGENT_IP, agentIp);
            // 模拟Nginx在请求头中加入X-Real-IP，后面微服务可就此取得实际的用户IP
            ctx.getZuulRequestHeaders().put("X-Real-IP", agentIp);
            // 获取到用户浏览器的信息
            final String userAgent = AgentUtils.getUserAgent(req);
            log.info("将用户浏览器的信息加入到ctx中传递给其它过滤器");
            ctx.set(ZuulCo.USER_AGENT, userAgent);

            log.debug("判断IP是否匹配黑名单");
            if (ipBlackList != null && !ipBlackList.isEmpty()) {
                if (ipBlackList.stream().anyMatch((blackIp) -> blackIp.equals(agentIp))) {
                    final String msg = "匹配IP黑名单";
                    log.error(msg);
                    ctx.setSendZuulResponse(false); // 过滤该请求，不对其进行路由
                    ctx.setResponseStatusCode(403); // 返回错误码
                    throw new RuntimeException(msg);
                }
            }

            return null;
        } finally {
            log.info("\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 结束IpPreFilter过滤器 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n");
        }
    }
}