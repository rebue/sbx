package rebue.scx.rac.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;

/**
 * 用户角色
 *
 * 数据库表: RAC_USER_ROLE
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Schema(description = "用户角色")
@JsonInclude(Include.NON_NULL)
public class RacUserRoleMo implements Serializable {

    /**
     *    用户角色ID
     *
     *    数据库字段: RAC_USER_ROLE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Schema(description = "用户角色ID")
    private Long id;

    /**
     *    系统ID
     *
     *    数据库字段: RAC_USER_ROLE.SYS_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Schema(description = "系统ID")
    private String sysId;

    /**
     *    角色ID
     *
     *    数据库字段: RAC_USER_ROLE.ROLE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Schema(description = "角色ID")
    private String roleId;

    /**
     *    用户ID(如为1则是散客)
     *
     *    数据库字段: RAC_USER_ROLE.USER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Schema(description = "用户ID(如为1则是散客)")
    private Long userId;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    用户角色ID
     *
     *    数据库字段: RAC_USER_ROLE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    用户角色ID
     *
     *    数据库字段: RAC_USER_ROLE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    系统ID
     *
     *    数据库字段: RAC_USER_ROLE.SYS_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSysId() {
        return sysId;
    }

    /**
     *    系统ID
     *
     *    数据库字段: RAC_USER_ROLE.SYS_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    /**
     *    角色ID
     *
     *    数据库字段: RAC_USER_ROLE.ROLE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     *    角色ID
     *
     *    数据库字段: RAC_USER_ROLE.ROLE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     *    用户ID(如为1则是散客)
     *
     *    数据库字段: RAC_USER_ROLE.USER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getUserId() {
        return userId;
    }

    /**
     *    用户ID(如为1则是散客)
     *
     *    数据库字段: RAC_USER_ROLE.USER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sysId=").append(sysId);
        sb.append(", roleId=").append(roleId);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RacUserRoleMo other = (RacUserRoleMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}