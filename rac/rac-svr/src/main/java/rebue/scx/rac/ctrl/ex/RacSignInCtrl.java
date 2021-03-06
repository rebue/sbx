package rebue.scx.rac.ctrl.ex;

import static rebue.scx.rac.ctrl.ex.SignUpOrInCtrlCommon.jwtSignWithCookie;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.scx.rac.api.ex.RacSignInApi;
import rebue.scx.rac.ra.SignUpOrInRa;
import rebue.scx.rac.to.ex.SignInByAccountNameTo;

/**
 * 账户登录的控制器
 */
@RestController
public class RacSignInCtrl {

    @Resource
    private RacSignInApi api;

    /**
     * 通过账户名称登录
     */
    @PostMapping("/rac/sign-in/sign-in-by-account-name")
    public Mono<Ro<SignUpOrInRa>> signInByAccountName(@RequestBody final SignInByAccountNameTo to, HttpServletResponse resp) {
        return Mono.create(callback -> {
            Ro<SignUpOrInRa> ro = api.signInByAccountName(to);
            if (ResultDic.SUCCESS.equals(ro.getResult()))
                jwtSignWithCookie(ro.getExtra(), to.getSysId(), resp);
            callback.success(ro);
        });
    }

}
