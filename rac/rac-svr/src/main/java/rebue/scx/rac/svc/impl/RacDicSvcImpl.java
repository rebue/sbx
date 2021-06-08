package rebue.scx.rac.svc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageInfo;

import rebue.robotech.svc.BaseSvc;
import rebue.robotech.svc.impl.BaseSvcImpl;
import rebue.scx.rac.dao.RacDicDao;
import rebue.scx.rac.jo.RacDicJo;
import rebue.scx.rac.mapper.RacDicItemMapper;
import rebue.scx.rac.mapper.RacDicMapper;
import rebue.scx.rac.mo.RacDicItemMo;
import rebue.scx.rac.mo.RacDicMo;
import rebue.scx.rac.ra.DicListWithItemRa;
import rebue.scx.rac.svc.RacDicSvc;
import rebue.scx.rac.to.RacDicAddTo;
import rebue.scx.rac.to.RacDicDelTo;
import rebue.scx.rac.to.RacDicListTo;
import rebue.scx.rac.to.RacDicModifyTo;
import rebue.scx.rac.to.RacDicOneTo;
import rebue.scx.rac.to.RacDicPageTo;
import rebue.scx.rac.to.ex.DicListWithItemTo;

/**
 * 字典服务实现
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
public class RacDicSvcImpl
        extends BaseSvcImpl<java.lang.String, RacDicAddTo, RacDicModifyTo, RacDicDelTo, RacDicOneTo, RacDicListTo, RacDicPageTo, RacDicMo, RacDicJo, RacDicMapper, RacDicDao>
        implements RacDicSvc {

    /**
     * 本服务的单例
     * 注意：内部调用自己的方法，如果涉及到回滚事务的，请不要直接调用，而是通过本实例调用
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Lazy
    @Resource
    private RacDicSvc        thisSvc;

    @Resource
    private RacDicItemMapper racDicItemMapper;

    /**
     * 从接口获取本服务的单例(提供给基类调用)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    protected BaseSvc<java.lang.String, RacDicAddTo, RacDicModifyTo, RacDicDelTo, RacDicOneTo, RacDicListTo, RacDicPageTo, RacDicMo, RacDicJo> getThisSvc() {
        return thisSvc;
    }

    /**
     * 查询字典的信息
     *
     * @param qo 查询的具体条件
     */

    @Override
    public DicListWithItemRa listWithDic(DicListWithItemTo qo) {
        final DicListWithItemRa ra             = new DicListWithItemRa();
        final ISelect           select         = () -> _mapper.selectPageOrKeywords(qo);
        PageInfo<RacDicMo>      dicPage        = thisSvc.page(select, qo.getPageNum(), qo.getPageSize(), null);
        List<RacDicMo>          dicList        = dicPage.getList();
        List<RacDicItemMo>      dicItemListAll = new ArrayList<RacDicItemMo>();
        for (RacDicMo racDicMo : dicList) {
            final RacDicItemMo moQo = new RacDicItemMo();
            moQo.setDicId(racDicMo.getId());
            List<RacDicItemMo> dicItemList = racDicItemMapper.selectSelective(moQo);
            dicItemListAll.addAll(dicItemList);
        }
        dicPage.setList(null);// 只需要分页的参数
        ra.setPage(dicPage);
        ra.setDicList(dicList);
        ra.setItemList(dicItemListAll);
        return ra;
    }

    /**
     * 泛型MO的class(提供给基类调用-因为java中泛型擦除，JVM无法智能获取泛型的class)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    protected Class<RacDicMo> getMoClass() {
        return RacDicMo.class;
    }

}
