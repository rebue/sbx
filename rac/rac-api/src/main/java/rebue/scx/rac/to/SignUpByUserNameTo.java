package rebue.scx.rac.to;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 通过用户名称注册要传递的参数
 */
@Schema(description = "通过用户名称注册要传递的参数")
@Data
@JsonInclude(Include.NON_NULL)
public class SignUpByUserNameTo {

    /**
     * 系统ID
     */
    @Schema(description = "系统ID")
    @NotBlank(message = "系统ID不能为空")
    @Length(max = 20, message = "系统ID长度不能超过20")
    private String sysId;

    /**
     * 组织ID
     */
    @Schema(description = "组织ID")
    private Long orgId;

    /**
     * 用户名称(手机号/电子邮箱/登录名称)
     */
    @Schema(description = "用户名称(手机号/电子邮箱/登录名称)")
    @NotBlank(message = "用户名称不能为空")
    @Length(max = 50, message = "用户名长度不能超过50位")
    private String userName;

    /**
     * 登录密码
     */
    @Schema(description = "登录密码")
    @NotBlank(message = "登录密码不能为空")
    @Length(max = 32, message = "登录密码长度不能超过32位")
    private String signInPswd;

    /**
     * 昵称
     */
    @Schema(description = "昵称")
    private String nickname;

    /**
     * 实名
     */
    @Schema(description = "实名")
    private String realname;

    /**
     * 身份证号
     */
    @Schema(description = "身份证号")
    private String idcard;
}
