package rebue.scx.rac.svc;

import org.springframework.validation.annotation.Validated;

import rebue.robotech.svc.BaseSvc;
import rebue.scx.rac.jo.RacPersonJo;
import rebue.scx.rac.mo.RacPersonMo;
import rebue.scx.rac.to.RacPersonAddTo;
import rebue.scx.rac.to.RacPersonDelTo;
import rebue.scx.rac.to.RacPersonListTo;
import rebue.scx.rac.to.RacPersonModifyTo;
import rebue.scx.rac.to.RacPersonOneTo;

// @Validated注解按规范应该写在接口上；@Valid注解在参数是POJO类时写在参数类型的前面，具体约束的注解写在参数类型的属性的上方；而普通参数则写在方法的上方，具体约束的注解直接写在参数类型的前面
@Validated
public interface RacPersonSvc extends BaseSvc<java.lang.Long, RacPersonAddTo, RacPersonModifyTo, RacPersonDelTo, RacPersonOneTo, RacPersonListTo, RacPersonMo, RacPersonJo> {
}
