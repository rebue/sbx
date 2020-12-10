package rebue.scx.rac.svc.impl;

import static org.mybatis.dynamic.sql.SqlBuilder.and;
import static org.mybatis.dynamic.sql.SqlBuilder.equalTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualToWhenPresent;
import static rebue.scx.rac.mapper.RacDomainUserDynamicSqlSupport.racDomainUser;
import static rebue.scx.rac.mapper.RacOrgUserDynamicSqlSupport.racOrgUser;
import static rebue.scx.rac.mapper.RacUserDynamicSqlSupport.racUser;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.dynamic.sql.SqlCriterion;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.scx.rac.dao.RacUserDao;
import rebue.scx.rac.jo.RacUserJo;
import rebue.scx.rac.mapper.RacUserMapper;
import rebue.scx.rac.mo.RacUserMo;
import rebue.scx.rac.svc.RacUserSvc;
import rebue.scx.rac.to.RacUserAddTo;
import rebue.scx.rac.to.RacUserDelTo;
import rebue.scx.rac.to.RacUserListTo;
import rebue.scx.rac.to.RacUserModifyTo;
import rebue.scx.rac.to.RacUserOneTo;

/**
 * 用户服务实现
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
public class RacUserSvcImpl
    extends BaseSvcImpl<java.lang.Long, RacUserAddTo, RacUserModifyTo, RacUserDelTo, RacUserOneTo, RacUserListTo, RacUserMo, RacUserJo, RacUserMapper, RacUserDao>
    implements RacUserSvc {

    /**
     * 本服务的单例 注意：内部调用自己的方法，如果涉及到回滚事务的，请不要直接调用，而是通过本实例调用
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Lazy
    @Resource
    private RacUserSvc thisSvc;

    /**
     * 泛型MO的class(应为java中泛型擦除，JVM无法智能获取泛型的class)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    protected Class<RacUserMo> getMoClass() {
        return RacUserMo.class;
    }

    /**
     * 通过email获取用户信息
     *
     * @param domainId 领域ID
     * @param orgId    组织ID
     * @param email    电子邮箱
     *
     * @return 用户信息
     */
    @Override
    public RacUserMo getOneByEmail(final String domainId, final Long orgId, final String email) {
        final List<SqlCriterion<?>> list = new LinkedList<>();
        if (orgId != null) {
            list.add(and(racOrgUser.orgId, isEqualTo(orgId)));
        }
        list.add(and(racUser.signInEmail, isEqualTo(email)));
        return _mapper.selectOne(c -> c
            .rightJoin(racDomainUser).on(racDomainUser.userId, equalTo(racUser.id))
            .rightJoin(racOrgUser).on(racOrgUser.userId, equalTo(racUser.id))
            .where(
                racDomainUser.domainId, isEqualTo(domainId),
                // list.stream().toArray(SqlCriterion<?>[]::new)))
                and(racOrgUser.orgId, isEqualToWhenPresent(orgId)),
                and(racUser.signInEmail, isEqualTo(email))))
            .orElse(null);
    }

    @Override
    public RacUserMo getOneByMobile(final String domainId, final Long orgId, final String mobile) {
        return _mapper.selectOne(c -> c
            .rightJoin(racDomainUser).on(racDomainUser.userId, equalTo(racUser.id))
            .rightJoin(racOrgUser).on(racOrgUser.userId, equalTo(racUser.id))
            .where(
                racDomainUser.domainId, isEqualTo(domainId),
                and(racOrgUser.orgId, isEqualToWhenPresent(orgId)),
                and(racUser.signInMobile, isEqualTo(mobile))))
            .orElse(null);
    }

    @Override
    public RacUserMo getOneBySignInName(final String domainId, final Long orgId, final String signInName) {
        return _mapper.selectOne(c -> {
            final QueryExpressionDSL<SelectModel>.JoinSpecificationFinisher join = c
                .rightJoin(racDomainUser).on(racDomainUser.userId, equalTo(racUser.id));

            if (orgId != null) {
                join.rightJoin(racOrgUser).on(racOrgUser.userId, equalTo(racUser.id));
            }

            return join.where(
                racDomainUser.domainId, isEqualTo(domainId),
                and(racOrgUser.orgId, isEqualToWhenPresent(orgId)),
                and(racUser.signInName, isEqualTo(signInName)));
        }).orElse(null);
    }
}
