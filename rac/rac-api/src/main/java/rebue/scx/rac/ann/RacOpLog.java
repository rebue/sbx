package rebue.scx.rac.ann;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 添加操作日志注解
 *
 * XXX 此注解放在API实现层
 *
 * @author zbz
 *
 */
@Target({ ElementType.METHOD
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RacOpLog {
    /**
     * 类型
     */
    String opType();

    /**
     * 标题
     */
    String opTitle();

    /**
     * 详情
     */
    String opDetail();
}
