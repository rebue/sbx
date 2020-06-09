package rebue.scx.rac.ctrl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import rebue.robotech.ro.Ro;
import rebue.scx.rac.svc.RacApiSignUpSvc;
import rebue.scx.rac.to.SignUpByUserNameTo;

/**
 * API用户注册的控制器
 */
@RestController
public class RacApiSignUpCtrl {

    @Resource
    private RacApiSignUpSvc svc;

    /**
     * 通过用户名称注册
     */
    @PostMapping("/api/sign-up/sign-up-by-user-name")
    public Mono<Ro> signUpByUserName(@RequestBody final SignUpByUserNameTo to) {
        return Mono.create(callback -> callback.success(svc.signUpByUserName(to)));
    }

}
