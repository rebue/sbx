package rebue.scx.rac.svc;

import org.springframework.validation.annotation.Validated;

import rebue.robotech.svc.BaseSvc;
import rebue.scx.rac.jo.RacSysJo;
import rebue.scx.rac.mo.RacSysMo;
import rebue.scx.rac.to.RacSysAddTo;
import rebue.scx.rac.to.RacSysDelTo;
import rebue.scx.rac.to.RacSysListTo;
import rebue.scx.rac.to.RacSysModifyTo;
import rebue.scx.rac.to.RacSysOneTo;
import rebue.scx.rac.to.RacSysPageTo;

/**
 * 系统服务接口
 *
 * <pre>
 * 1. 在接口上方必须写上 @Validated 注解
 * 2. 参数是POJO类时用 @Valid 注解在参数类型的前面进行修饰
 *    参数是普通参数时，直接在参数类型的前面加上具体约束的注解
 * 3. (待验证)有分组时，在方法上方必须写上 @Validated 注解及分组
 * 4. 踩坑留痕：
 *    如果方法的返回值为void，在方法上方加上 @Valid 注解会出现异常，报HV000132错误
 * </pre>
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Validated
public interface RacSysSvc extends BaseSvc<java.lang.String, RacSysAddTo, RacSysModifyTo, RacSysDelTo, RacSysOneTo, RacSysListTo, RacSysPageTo, RacSysMo, RacSysJo> {
}
