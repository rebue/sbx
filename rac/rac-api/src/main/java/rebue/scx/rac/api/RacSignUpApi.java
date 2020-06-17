package rebue.scx.rac.api;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import rebue.robotech.ro.Ro;
import rebue.scx.rac.ra.SignUpRa;
import rebue.scx.rac.to.SignUpByUserNameTo;

/**
 * API用户注册服务
 */
//@Validated注解按规范应该分别写在接口上；@Valid注解在参数是POJO类时写在参数类型的前面，具体约束的注解写在参数类型的属性的上方；而普通参数则写在方法的上方，具体约束的注解直接写在参数类型的前面
@Validated
public interface RacSignUpApi {

    /**
     * 通过用户名称注册
     */
    Ro<SignUpRa> signUpByUserName(@Valid SignUpByUserNameTo to);

}