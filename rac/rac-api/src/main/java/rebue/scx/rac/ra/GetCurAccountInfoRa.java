package rebue.scx.rac.ra;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 当前账户信息
 *
 */
@Data
@NoArgsConstructor
// @RequiredArgsConstructor // 不知道@Data中默认包含的@RequiredArgsConstructor为何没起效
@JsonInclude(Include.NON_NULL)
public class GetCurAccountInfoRa implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     */
    private Long              id;

    /**
     * 账户昵称
     */
    private String            nickname;

    /**
     * 账户头像
     */
    private String            avatar;

    /**
     * 是否测试者
     */
    private Boolean           isTester;

    /**
     * 菜单列表
     */
    private List<String>      menus;

}
