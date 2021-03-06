package rebue.scx.rac.ctrl;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import rebue.robotech.ra.BooleanRa;
import rebue.robotech.ra.IdRa;
import rebue.robotech.ra.PageRa;
import rebue.robotech.ra.PojoRa;
import rebue.robotech.ro.Ro;
import rebue.scx.rac.api.RacPermApi;
import rebue.scx.rac.mo.RacPermMo;
import rebue.scx.rac.ra.PermListWithGroupRa;
import rebue.scx.rac.to.RacPermAddTo;
import rebue.scx.rac.to.RacPermModifyTo;
import rebue.scx.rac.to.RacPermPageTo;

/**
 * 权限控制器
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class RacPermCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private RacPermApi api;

    /**
     * 添加权限
     *
     * @param to 添加的具体信息
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PostMapping("/rac/perm")
    public Mono<Ro<IdRa<java.lang.Long>>> add(@RequestBody final RacPermAddTo to) {
        return Mono.create(callback -> callback.success(api.add(to)));
    }

    /**
     * 修改权限的信息
     *
     * @param to 修改的具体数据
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/rac/perm")
    public Mono<Ro<?>> modify(@RequestBody final RacPermModifyTo to) {
        return Mono.create(callback -> callback.success(api.modify(to)));
    }

    /**
     * 删除权限
     *
     * @param id 权限ID
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/rac/perm")
    public Mono<Ro<?>> del(@RequestParam("id") final java.lang.Long id) {
        return Mono.create(callback -> callback.success(api.del(id)));
    }

    /**
     * 获取单个权限的信息
     *
     * @param id 权限ID
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/rac/perm/get-by-id")
    public Mono<Ro<PojoRa<RacPermMo>>> getById(@RequestParam("id") final java.lang.Long id) {
        return Mono.create(callback -> callback.success(api.getById(id)));
    }

    /**
     * 判断权限是否存在
     *
     * @param id 权限ID
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/rac/perm/exist-by-id")
    public Mono<Ro<BooleanRa>> existById(@RequestParam("id") final java.lang.Long id) {
        return Mono.create(callback -> callback.success(api.existById(id)));
    }

    /**
     * 查询权限的信息
     *
     * @param qo 查询的具体条件
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/rac/perm/page")
    public Mono<Ro<PageRa<RacPermMo>>> page(final RacPermPageTo qo) {
        return Mono.create(callback -> callback.success(api.page(qo)));
    }

    /**
     * 查询带分组的权限列表
     *
     * @param domainId 领域ID
     */
    @GetMapping("/rac/perm/list-with-group")
    public Mono<Ro<PermListWithGroupRa>> listWithGroup(@RequestParam("domainId") final String domainId) {
        return Mono.create(callback -> callback.success(api.listWithGroup(domainId)));
    }
}
