package rebue.scx.rac.svc.impl;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.scx.rac.dao.RacMenuDao;
import rebue.scx.rac.jo.RacMenuJo;
import rebue.scx.rac.mapper.RacMenuMapper;
import rebue.scx.rac.mo.RacMenuMo;
import rebue.scx.rac.svc.RacMenuSvc;

/**
 * 菜单信息
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
public class RacMenuSvcImpl extends BaseSvcImpl<java.lang.String, RacMenuJo, RacMenuDao, RacMenuMo, RacMenuMapper> implements RacMenuSvc {

    /**
     * 本服务的单例
     * 注意：内部调用自己的方法，如果涉及到回滚事务的，请不要直接调用，而是通过本实例调用
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    // @Lazy
    // @Resource
    // private RacMenuSvc thisSvc;
    /**
     * 添加菜单信息(自动生成ID)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public Ro add(final RacMenuMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId().trim().isEmpty()) {
            mo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        final Ro ro = super.add(mo);
        if (ResultDic.SUCCESS.equals(ro.getResult())) {
            return new IdRo<>(ro.getResult(), ro.getMsg(), mo.getId());
        } else {
            return ro;
        }
    }
}
