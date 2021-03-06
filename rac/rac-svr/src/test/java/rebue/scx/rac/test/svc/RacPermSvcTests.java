package rebue.scx.rac.test.svc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import rebue.scx.rac.mo.RacPermMo;
import rebue.scx.rac.svc.RacPermSvc;
import rebue.scx.rac.to.RacPermAddTo;
import rebue.scx.rac.to.RacPermModifyTo;
import rebue.scx.rac.to.RacPermPageTo;
import rebue.wheel.core.RandomEx;

/**
 * 权限 Service层测试
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Slf4j
@SpringBootTest
public class RacPermSvcTests {

    /**
     * 要测试的微服务
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Autowired
    private RacPermSvc _svc;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Autowired
    private Mapper     dozerMapper;

    /**
     * 测试基本的增删改查
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Test
    public void testCrud() {
        RacPermAddTo addTo = null;
        Long id = null;
        for (int i = 0; i < 20; i++) {
            addTo = (RacPermAddTo) RandomEx.randomPojo(RacPermAddTo.class);
            log.info("添加权限的参数为：" + addTo);
            final RacPermMo addRo = _svc.add(addTo);
            log.info("添加权限的返回值为：" + addRo);
            Assertions.assertNotNull(addRo);
            id = addRo.getId();
        }
        final PageInfo<RacPermMo> pageResult = _svc.page(new RacPermPageTo());
        log.info("查询权限的返回值为：" + pageResult);
        Assertions.assertNotNull(pageResult);
        log.info("获取单个权限的参数为：" + id);
        RacPermMo getByIdResult = _svc.getById(id);
        log.info("获取单个权限的返回值为：" + getByIdResult);
        Assertions.assertNotNull(getByIdResult);
        final RacPermModifyTo modifyTo = dozerMapper.map(addTo, RacPermModifyTo.class);
        modifyTo.setId(id);
        log.info("修改权限的参数为：" + modifyTo);
        _svc.modifyById(modifyTo);
        log.info("删除权限的参数为：" + id);
        _svc.delById(id);
    }
}
