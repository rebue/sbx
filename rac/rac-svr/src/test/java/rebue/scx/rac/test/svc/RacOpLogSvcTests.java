package rebue.scx.rac.test.svc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import rebue.scx.rac.mo.RacOpLogMo;
import rebue.scx.rac.svc.RacOpLogSvc;
import rebue.scx.rac.to.RacOpLogAddTo;
import rebue.scx.rac.to.RacOpLogModifyTo;
import rebue.scx.rac.to.RacOpLogPageTo;
import rebue.wheel.core.RandomEx;

/**
 * 操作日志 Service层测试
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Slf4j
@SpringBootTest
public class RacOpLogSvcTests {

    /**
     * 要测试的微服务
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Autowired
    private RacOpLogSvc _svc;

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
            final RacOpLogMo addRo = _svc.add(addTo);
            log.info("添加操作日志的返回值为：" + addRo);
            Assertions.assertNotNull(addRo);
            id = addRo.getId();
        }
        final PageInfo<RacOpLogMo> pageResult = _svc.page(new RacOpLogPageTo());
        log.info("查询操作日志的返回值为：" + pageResult);
        Assertions.assertNotNull(pageResult);
        log.info("获取单个操作日志的参数为：" + id);
        RacOpLogMo getByIdResult = _svc.getById(id);
        log.info("获取单个操作日志的返回值为：" + getByIdResult);
        Assertions.assertNotNull(getByIdResult);
        final RacOpLogModifyTo modifyTo = dozerMapper.map(addTo, RacOpLogModifyTo.class);
        modifyTo.setId(id);
        log.info("修改操作日志的参数为：" + modifyTo);
        _svc.modifyById(modifyTo);
        log.info("删除操作日志的参数为：" + id);
        _svc.delById(id);
    }
}
