package rebue.scx.rac.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 组织信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class RacOrgMo implements Serializable {

    /**
     * 组织ID(组织ID=账户ID，与账户一一对应)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     * 组织名称(简称)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String name;

    /**
     * 上级组织ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long parentId;

    /**
     * 组织类型(1.集团;2.公司;99.部门)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte orgType;

    /**
     * 左值
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer leftValue;

    /**
     * 右值
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer rightValue;

    /**
     * 组织全名
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String fullName;

    /**
     * 组织简介
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String introduction;

    /**
     * 组织备注
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String remark;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     * 组织ID(组织ID=账户ID，与账户一一对应)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     * 组织ID(组织ID=账户ID，与账户一一对应)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 组织名称(简称)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getName() {
        return name;
    }

    /**
     * 组织名称(简称)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上级组织ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 上级组织ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 组织类型(1.集团;2.公司;99.部门)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getOrgType() {
        return orgType;
    }

    /**
     * 组织类型(1.集团;2.公司;99.部门)
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrgType(Byte orgType) {
        this.orgType = orgType;
    }

    /**
     * 左值
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getLeftValue() {
        return leftValue;
    }

    /**
     * 左值
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setLeftValue(Integer leftValue) {
        this.leftValue = leftValue;
    }

    /**
     * 右值
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getRightValue() {
        return rightValue;
    }

    /**
     * 右值
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setRightValue(Integer rightValue) {
        this.rightValue = rightValue;
    }

    /**
     * 组织全名
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 组织全名
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 组织简介
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 组织简介
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 组织备注
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 组织备注
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", parentId=").append(parentId);
        sb.append(", orgType=").append(orgType);
        sb.append(", leftValue=").append(leftValue);
        sb.append(", rightValue=").append(rightValue);
        sb.append(", fullName=").append(fullName);
        sb.append(", introduction=").append(introduction);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
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
        RacOrgMo other = (RacOrgMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
