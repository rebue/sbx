package rebue.scx.rac.svc.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.robotech.svc.BaseSvc;
import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.scx.rac.dao.RacPermGroupDao;
import rebue.scx.rac.jo.RacPermGroupJo;
import rebue.scx.rac.mapper.RacPermGroupMapper;
import rebue.scx.rac.mo.RacPermGroupMo;
import rebue.scx.rac.svc.RacPermGroupSvc;
import rebue.scx.rac.to.RacPermGroupAddTo;
import rebue.scx.rac.to.RacPermGroupDelTo;
import rebue.scx.rac.to.RacPermGroupListTo;
import rebue.scx.rac.to.RacPermGroupModifyTo;
import rebue.scx.rac.to.RacPermGroupOneTo;
import rebue.scx.rac.to.RacPermGroupPageTo;

/**
 * 权限分组服务实现
 *
 * <pre>
 * 注意：
 * 1. 查询数据库操作的方法，不用设置默认 @Transactional
 *    在类上方已经设置默认为 readOnly=true, propagation=Propagation.SUPPORTS
 *    而涉及到 增删改 数据库操作的方法时，要设置 readOnly=false, propagation=Propagation.REQUIRED
 * 2. 事务不会针对受控异常（checked exception）回滚
 *    要想回滚事务，须抛出运行时异常(RuntimeException)
 * 3. 如果类上方不带任何参数的 @Transactional 注解时，如同下面的设置
 *    propagation(传播模式)=REQUIRED，readOnly=false，isolation(事务隔离级别)=READ_COMMITTED
 * </pre>
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class RacPermGroupSvcImpl extends
    BaseSvcImpl<java.lang.Long, RacPermGroupAddTo, RacPermGroupModifyTo, RacPermGroupDelTo, RacPermGroupOneTo, RacPermGroupListTo, RacPermGroupPageTo, RacPermGroupMo, RacPermGroupJo, RacPermGroupMapper, RacPermGroupDao>
    implements RacPermGroupSvc {

    /**
     * 本服务的单例
     * 注意：内部调用自己的方法，如果涉及到回滚事务的，请不要直接调用，而是通过本实例调用
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Lazy
    @Resource
    private RacPermGroupSvc thisSvc;

    /**
     * 泛型MO的class(提供给基类调用-因为java中泛型擦除，JVM无法智能获取泛型的class)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    protected Class<RacPermGroupMo> getMoClass() {
        return RacPermGroupMo.class;
    }

    /**
     * 从接口获取本服务的单例(提供给基类调用)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    protected BaseSvc<java.lang.Long, RacPermGroupAddTo, RacPermGroupModifyTo, RacPermGroupDelTo, RacPermGroupOneTo, RacPermGroupListTo, RacPermGroupPageTo, RacPermGroupMo, RacPermGroupJo> getThisSvc() {
        return thisSvc;
    }
}
