package rebue.scx.rac.test.svc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import rebue.scx.rac.mo.RacDomainMo;
import rebue.scx.rac.svc.RacDomainSvc;
import rebue.scx.rac.to.RacDomainAddTo;
import rebue.scx.rac.to.RacDomainModifyTo;
import rebue.scx.rac.to.RacDomainPageTo;
import rebue.wheel.core.RandomEx;

/**
 * 领域 Service层测试
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Slf4j
@SpringBootTest
public class RacDomainSvcTests {

    /**
     * 要测试的微服务
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Autowired
    private RacDomainSvc _svc;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Autowired
    private Mapper       dozerMapper;

    /**
     * 测试基本的增删改查
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Test
    public void testCrud() {
        RacDomainAddTo addTo = null;
        String id = null;
        for (int i = 0; i < 20; i++) {
            addTo = (RacDomainAddTo) RandomEx.randomPojo(RacDomainAddTo.class);
            log.info("添加领域的参数为：" + addTo);
            final RacDomainMo addRo = _svc.add(addTo);
            log.info("添加领域的返回值为：" + addRo);
            Assertions.assertNotNull(addRo);
            id = addRo.getId();
        }
        final PageInfo<RacDomainMo> pageResult = _svc.page(new RacDomainPageTo());
        log.info("查询领域的返回值为：" + pageResult);
        Assertions.assertNotNull(pageResult);
        log.info("获取单个领域的参数为：" + id);
        RacDomainMo getByIdResult = _svc.getById(id);
        log.info("获取单个领域的返回值为：" + getByIdResult);
        Assertions.assertNotNull(getByIdResult);
        final RacDomainModifyTo modifyTo = dozerMapper.map(addTo, RacDomainModifyTo.class);
        modifyTo.setId(id);
        log.info("修改领域的参数为：" + modifyTo);
        _svc.modifyById(modifyTo);
        log.info("删除领域的参数为：" + id);
        _svc.delById(id);
    }
}
