package rebue.scx.rac.test.api;

import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.dozermapper.core.Mapper;

import lombok.extern.slf4j.Slf4j;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ra.IdRa;
import rebue.robotech.ra.PageRa;
import rebue.robotech.ra.PojoRa;
import rebue.robotech.ro.Ro;
import rebue.scx.rac.api.RacOpLogApi;
import rebue.scx.rac.mo.RacOpLogMo;
import rebue.scx.rac.to.RacOpLogAddTo;
import rebue.scx.rac.to.RacOpLogModifyTo;
import rebue.scx.rac.to.RacOpLogPageTo;
import rebue.wheel.core.RandomEx;

/**
 * 操作日志 API层测试
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Slf4j
@SpringBootTest
public class RacOpLogApiTests {

    /**
     * 要测试的API
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DubboReference
    private RacOpLogApi _api;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Autowired
    private Mapper      dozerMapper;

    /**
     * 测试基本的增删改查
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Test
    public void testCrud() {
        RacOpLogAddTo addTo = null;
        Long id = null;
        for (int i = 0; i < 20; i++) {
            addTo = (RacOpLogAddTo) RandomEx.randomPojo(RacOpLogAddTo.class);
            log.info("添加操作日志的参数为：" + addTo);
            final Ro<IdRa<Long>> idRo = _api.add(addTo);
            log.info("添加操作日志的返回值为：" + idRo);
            Assertions.assertEquals(ResultDic.SUCCESS, idRo.getResult());
            id = idRo.getExtra().getId();
        }
        final Ro<PageRa<RacOpLogMo>> pageResult = _api.page(new RacOpLogPageTo());
        log.info("查询操作日志的返回值为：" + pageResult);
        Assertions.assertEquals(ResultDic.SUCCESS, pageResult.getResult());
        log.info("获取单个操作日志的参数为：" + id);
        final Ro<PojoRa<RacOpLogMo>> getByIdResult = _api.getById(id);
        log.info("获取单个操作日志的返回值为：" + getByIdResult);
        final RacOpLogModifyTo modifyTo = dozerMapper.map(addTo, RacOpLogModifyTo.class);
        modifyTo.setId(id);
        log.info("修改操作日志的参数为：" + modifyTo);
        final Ro<?> modifyResult = _api.modify(modifyTo);
        log.info("修改操作日志的返回值为：" + modifyResult);
        Assertions.assertEquals(ResultDic.SUCCESS, modifyResult.getResult());
        log.info("删除操作日志的参数为：" + id);
        final Ro<?> deleteResult = _api.del(id);
        log.info("删除操作日志的返回值为：" + deleteResult);
        Assertions.assertEquals(ResultDic.SUCCESS, deleteResult.getResult());
    }
}
