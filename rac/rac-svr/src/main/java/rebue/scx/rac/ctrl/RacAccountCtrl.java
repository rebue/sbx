package rebue.scx.rac.ctrl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import rebue.robotech.ra.BooleanRa;
import rebue.robotech.ra.IdRa;
import rebue.robotech.ra.PageRa;
import rebue.robotech.ra.PojoRa;
import rebue.robotech.ro.Ro;
import rebue.scx.rac.api.RacAccountApi;
import rebue.scx.rac.co.RacCo;
import rebue.scx.rac.mo.RacAccountMo;
import rebue.scx.rac.ra.GetCurAccountInfoRa;
import rebue.scx.rac.to.RacAccountAddTo;
import rebue.scx.rac.to.RacAccountModifyTo;
import rebue.scx.rac.to.RacAccountPageTo;
import rebue.wheel.CookieUtils;
import rebue.wheel.turing.JwtUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 账户控制器
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class RacAccountCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private RacAccountApi api;

    /**
     * 添加账户
     *
     * @param to 添加的具体信息
     * 
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PostMapping("/rac/account")
    public Mono<Ro<IdRa<java.lang.Long>>> add(@RequestBody final RacAccountAddTo to) {
        return Mono.create(callback -> callback.success(api.add(to)));
    }

    /**
     * 修改账户的信息
     *
     * @param to 修改的具体数据
     * 
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/rac/account")
    public Mono<Ro<?>> modify(@RequestBody final RacAccountModifyTo to) {
        return Mono.create(callback -> callback.success(api.modify(to)));
    }

    /**
     * 删除账户
     *
     * @param id 账户ID
     * 
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/rac/account")
    public Mono<Ro<?>> del(@RequestParam("id") final java.lang.Long id) {
        return Mono.create(callback -> callback.success(api.del(id)));
    }

    /**
     * 获取单个账户的信息
     *
     * @param id 账户ID
     * 
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/rac/account/get-by-id")
    public Mono<Ro<PojoRa<RacAccountMo>>> getById(@RequestParam("id") final java.lang.Long id) {
        return Mono.create(callback -> callback.success(api.getById(id)));
    }

    /**
     * 判断账户是否存在
     *
     * @param id 账户ID
     * 
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/rac/account/exist-by-id")
    public Mono<Ro<BooleanRa>> existById(@RequestParam("id") final java.lang.Long id) {
        return Mono.create(callback -> callback.success(api.existById(id)));
    }

    /**
     * 查询账户的信息
     *
     * @param qo 查询的具体条件
     * 
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/rac/account/page")
    public Mono<Ro<PageRa<RacAccountMo>>> page(final RacAccountPageTo qo) {
        return Mono.create(callback -> callback.success(api.page(qo)));
    }

    /**
     * 获取当前账户信息
     */
    @GetMapping("/rac/account/get-cur-account-info")
    public Mono<Ro<GetCurAccountInfoRa>> getCurAccountInfo(final HttpServletRequest req) {
        final Long curAccountId = JwtUtils.getJwtAccountIdInCookie(req);
        if (curAccountId == null) {
            throw new IllegalArgumentException("在Cookie中找不到账户ID");
        }
        final String curSysId = CookieUtils.getValue(req, RacCo.SYS_ID_KEY);
        if (StringUtils.isBlank(curSysId)) {
            throw new IllegalArgumentException("在Cookie中找不到系统ID");
        }
        return Mono.create(callback -> callback.success(api.getCurAccountInfo(curAccountId, curSysId)));
    }
}
