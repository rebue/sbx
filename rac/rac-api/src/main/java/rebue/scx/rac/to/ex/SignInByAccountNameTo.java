package rebue.scx.rac.to.ex;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 通过账户名称登录要传递的参数
 */
@Data
@JsonInclude(Include.NON_NULL)
public class SignInByAccountNameTo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 系统ID
     */
    @NotBlank(message = "系统ID不能为空")
    @Length(max = 20, message = "系统ID长度不能超过20")
    private String            sysId;

    /**
     * 账户名称(手机号/电子邮箱/登录名称)
     */
    @NotBlank(message = "账户名称不能为空")
    @Length(max = 50, message = "账户名长度不能超过50位")
    private String            accountName;

    /**
     * 登录密码
     */
    @NotBlank(message = "登录密码不能为空")
    @Length(max = 32, message = "登录密码长度不能超过32位")
    private String            signInPswd;

}
