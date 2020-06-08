package rebue.scx.rac.svc;

import org.springframework.validation.annotation.Validated;
import rebue.robotech.svc.BaseSvc;
import rebue.scx.rac.jo.RacSignInLogJo;
import rebue.scx.rac.mo.RacSignInLogMo;

/**
 * 用户登录日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
// @Validated注解按规范应该分别写在接口上；@Valid注解在参数是POJO类时写在参数类型的前面，具体约束的注解写在参数类型的属性的上方；而普通参数则写在方法的上方，具体约束的注解直接写在参数类型的前面
@Validated
public interface RacSignInLogSvc extends BaseSvc<java.lang.Long, RacSignInLogMo, RacSignInLogJo> {
}
