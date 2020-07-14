package rebue.scx.rac.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static rebue.scx.rac.mapper.RacRoleDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.scx.rac.mo.RacRoleMo;

@Mapper
public interface RacRoleMapper extends MybatisBaseMapper<RacRoleMo, String> {
    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, sysId, name, homePath, isEnabled, orderNo, remark);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RacRoleMo> insertStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RacRoleMo> multipleInsertStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("RacRoleMoResult")
    Optional<RacRoleMo> selectOne(SelectStatementProvider selectStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RacRoleMoResult", value = {
        @Result(column="ID", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="SYS_ID", property="sysId", jdbcType=JdbcType.VARCHAR),
        @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="HOME_PATH", property="homePath", jdbcType=JdbcType.VARCHAR),
        @Result(column="IS_ENABLED", property="isEnabled", jdbcType=JdbcType.BIT),
        @Result(column="ORDER_NO", property="orderNo", jdbcType=JdbcType.TINYINT),
        @Result(column="REMARK", property="remark", jdbcType=JdbcType.VARCHAR)
    })
    List<RacRoleMo> selectMany(SelectStatementProvider selectStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, racRole, completer);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, racRole, completer);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int insert(RacRoleMo record) {
        return MyBatis3Utils.insert(this::insert, record, racRole, c ->
            c.map(id).toProperty("id")
            .map(sysId).toProperty("sysId")
            .map(name).toProperty("name")
            .map(homePath).toProperty("homePath")
            .map(isEnabled).toProperty("isEnabled")
            .map(orderNo).toProperty("orderNo")
            .map(remark).toProperty("remark")
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int insertMultiple(Collection<RacRoleMo> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, racRole, c ->
            c.map(id).toProperty("id")
            .map(sysId).toProperty("sysId")
            .map(name).toProperty("name")
            .map(homePath).toProperty("homePath")
            .map(isEnabled).toProperty("isEnabled")
            .map(orderNo).toProperty("orderNo")
            .map(remark).toProperty("remark")
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int insertSelective(RacRoleMo record) {
        return MyBatis3Utils.insert(this::insert, record, racRole, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(sysId).toPropertyWhenPresent("sysId", record::getSysId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(homePath).toPropertyWhenPresent("homePath", record::getHomePath)
            .map(isEnabled).toPropertyWhenPresent("isEnabled", record::getIsEnabled)
            .map(orderNo).toPropertyWhenPresent("orderNo", record::getOrderNo)
            .map(remark).toPropertyWhenPresent("remark", record::getRemark)
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default Optional<RacRoleMo> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, racRole, completer);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default List<RacRoleMo> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, racRole, completer);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default List<RacRoleMo> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, racRole, completer);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default Optional<RacRoleMo> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, racRole, completer);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    static UpdateDSL<UpdateModel> updateAllColumns(RacRoleMo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(sysId).equalTo(record::getSysId)
                .set(name).equalTo(record::getName)
                .set(homePath).equalTo(record::getHomePath)
                .set(isEnabled).equalTo(record::getIsEnabled)
                .set(orderNo).equalTo(record::getOrderNo)
                .set(remark).equalTo(record::getRemark);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(RacRoleMo record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(sysId).equalToWhenPresent(record::getSysId)
                .set(name).equalToWhenPresent(record::getName)
                .set(homePath).equalToWhenPresent(record::getHomePath)
                .set(isEnabled).equalToWhenPresent(record::getIsEnabled)
                .set(orderNo).equalToWhenPresent(record::getOrderNo)
                .set(remark).equalToWhenPresent(record::getRemark);
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int updateByPrimaryKey(RacRoleMo record) {
        return update(c ->
            c.set(sysId).equalTo(record::getSysId)
            .set(name).equalTo(record::getName)
            .set(homePath).equalTo(record::getHomePath)
            .set(isEnabled).equalTo(record::getIsEnabled)
            .set(orderNo).equalTo(record::getOrderNo)
            .set(remark).equalTo(record::getRemark)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default int updateByPrimaryKeySelective(RacRoleMo record) {
        return update(c ->
            c.set(sysId).equalToWhenPresent(record::getSysId)
            .set(name).equalToWhenPresent(record::getName)
            .set(homePath).equalToWhenPresent(record::getHomePath)
            .set(isEnabled).equalToWhenPresent(record::getIsEnabled)
            .set(orderNo).equalToWhenPresent(record::getOrderNo)
            .set(remark).equalToWhenPresent(record::getRemark)
            .where(id, isEqualTo(record::getId))
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default Optional<RacRoleMo> selectOne(RacRoleMo record) {
        return selectOne(c ->
            c.where(id, isEqualTo(record::getId).when(Objects::nonNull))
            .and(sysId, isEqualTo(record::getSysId).when(Objects::nonNull))
            .and(name, isEqualTo(record::getName).when(Objects::nonNull))
            .and(homePath, isEqualTo(record::getHomePath).when(Objects::nonNull))
            .and(isEnabled, isEqualTo(record::getIsEnabled).when(Objects::nonNull))
            .and(orderNo, isEqualTo(record::getOrderNo).when(Objects::nonNull))
            .and(remark, isEqualTo(record::getRemark).when(Objects::nonNull))
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default long countSelective(RacRoleMo record) {
        return count(c ->
            c.where(id, isEqualTo(record::getId).when(Objects::nonNull))
            .and(sysId, isEqualTo(record::getSysId).when(Objects::nonNull))
            .and(name, isEqualTo(record::getName).when(Objects::nonNull))
            .and(homePath, isEqualTo(record::getHomePath).when(Objects::nonNull))
            .and(isEnabled, isEqualTo(record::getIsEnabled).when(Objects::nonNull))
            .and(orderNo, isEqualTo(record::getOrderNo).when(Objects::nonNull))
            .and(remark, isEqualTo(record::getRemark).when(Objects::nonNull))
        );
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default boolean existByPrimaryKey(String id_) {
        return count(c -> c.where(id, isEqualTo(id_))) > 0;
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default boolean existSelective(RacRoleMo record) {
        return countSelective(record) > 0;
    }

    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    default List<RacRoleMo> selectSelective(RacRoleMo record) {
        return select(c ->
            c.where(id, isEqualTo(record::getId).when(Objects::nonNull))
            .and(sysId, isEqualTo(record::getSysId).when(Objects::nonNull))
            .and(name, isEqualTo(record::getName).when(Objects::nonNull))
            .and(homePath, isEqualTo(record::getHomePath).when(Objects::nonNull))
            .and(isEnabled, isEqualTo(record::getIsEnabled).when(Objects::nonNull))
            .and(orderNo, isEqualTo(record::getOrderNo).when(Objects::nonNull))
            .and(remark, isEqualTo(record::getRemark).when(Objects::nonNull))
        );
    }
}