package rebue.scx.rac.ctrl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import rebue.robotech.ro.Ro;
import rebue.scx.rac.api.RacSignUpApi;
import rebue.scx.rac.ra.SignUpRa;
import rebue.scx.rac.to.SignUpByUserNameTo;

import javax.annotation.Resource;

/**
 * API用户注册的控制器
 */
@RestController
public class RacSignUpApiCtrl {

    @Resource
    private RacSignUpApi api;

    /**
     * 通过用户名称注册
     */
    @PostMapping("/api/sign-up/sign-up-by-user-name")
    public Mono<Ro<SignUpRa>> signUpByUserName(@RequestBody final SignUpByUserNameTo to) {
        return Mono.create(callback -> callback.success(api.signUpByUserName(to)));
    }

}
