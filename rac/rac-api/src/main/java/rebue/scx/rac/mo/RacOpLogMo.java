package rebue.scx.rac.mo;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import rebue.robotech.mo.Mo;
import rebue.robotech.valid.AddGroup;
import rebue.robotech.valid.ModifyGroup;

/**
 * 操作日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class RacOpLogMo implements Serializable, Mo<Long> {

    /**
     * 操作日志ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @NotNull(groups = ModifyGroup.class, message = "操作日志ID不能为空")
    @PositiveOrZero(message = "操作日志ID不能为负数")
    private Long              id;

    /**
     * 系统ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @NotBlank(groups = AddGroup.class, message = "系统ID不能为空")
    @Length(max = 32, message = "系统ID的长度不能大于32")
    private String            sysId;

    /**
     * 账户ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @NotNull(groups = AddGroup.class, message = "账户ID不能为空")
    @PositiveOrZero(message = "账户ID不能为负数")
    private Long              accountId;

    /**
     * 操作类型
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @NotBlank(groups = AddGroup.class, message = "操作类型不能为空")
    @Length(max = 20, message = "操作类型的长度不能大于20")
    private String            opType;

    /**
     * 操作标题
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @NotBlank(groups = AddGroup.class, message = "操作标题不能为空")
    @Length(max = 32, message = "操作标题的长度不能大于32")
    private String            opTitle;

    /**
     * 操作详情
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @NotBlank(groups = AddGroup.class, message = "操作详情不能为空")
    @Length(max = 300, message = "操作详情的长度不能大于300")
    private String            opDetail;

    /**
     * 操作时间
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NotNull(groups = AddGroup.class, message = "操作时间不能为空")
    private LocalDateTime     opDatetime;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     * 系统
     *
     * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
     */
    @Getter
    @Setter
    private RacSysMo          sys;

    /**
     * 账户
     *
     * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
     */
    @Getter
    @Setter
    private RacAccountMo      account;

    /**
     * 操作日志ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     * 操作日志ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 系统ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSysId() {
        return sysId;
    }

    /**
     * 系统ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    /**
     * 账户ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 账户ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     * 操作类型
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOpType() {
        return opType;
    }

    /**
     * 操作类型
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpType(String opType) {
        this.opType = opType;
    }

    /**
     * 操作标题
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOpTitle() {
        return opTitle;
    }

    /**
     * 操作标题
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpTitle(String opTitle) {
        this.opTitle = opTitle;
    }

    /**
     * 操作详情
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOpDetail() {
        return opDetail;
    }

    /**
     * 操作详情
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpDetail(String opDetail) {
        this.opDetail = opDetail;
    }

    /**
     * 操作时间
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public LocalDateTime getOpDatetime() {
        return opDatetime;
    }

    /**
     * 操作时间
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpDatetime(LocalDateTime opDatetime) {
        this.opDatetime = opDatetime;
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
        sb.append(", sysId=").append(sysId);
        sb.append(", accountId=").append(accountId);
        sb.append(", opType=").append(opType);
        sb.append(", opTitle=").append(opTitle);
        sb.append(", opDetail=").append(opDetail);
        sb.append(", opDatetime=").append(opDatetime);
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
        RacOpLogMo other = (RacOpLogMo) that;
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

    /**
     * 获取ID的类型
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String getIdType() {
        return "Long";
    }
}
