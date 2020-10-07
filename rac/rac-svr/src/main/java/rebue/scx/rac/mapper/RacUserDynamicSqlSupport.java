package rebue.scx.rac.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class RacUserDynamicSqlSupport {
    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public static final RacUser racUser = new RacUser();

    /**
    * 用户ID
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Long> id = racUser.id;

    /**
    * 个人ID
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Long> personId = racUser.personId;

    /**
    * 是否启用
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Boolean> isEnabled = racUser.isEnabled;

    /**
    * 登录名称
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInName = racUser.signInName;

    /**
    * 登录手机
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInMobile = racUser.signInMobile;

    /**
    * 登录邮箱
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInEmail = racUser.signInEmail;

    /**
    * 登录密码(小写(MD5(小写(MD5(密码明文))+小写(密码组合码))))
    *              注意：
    *              1. 计算方法中的密码在前端传过来时推荐先进行md5序列化，以避免在密码传递过程中使用明码被截获
    *              2. 密码组合码在生成密码时随机生成并保存下来，和密码组合起来使用，增加破解的难度
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInPswd = racUser.signInPswd;

    /**
    * 登录密码组合码(与密码组合加密用，详见登录密码备注)
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInPswdSalt = racUser.signInPswdSalt;

    /**
    * 登录用户昵称
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInNickname = racUser.signInNickname;

    /**
    * 登录用户头像
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> signInAvatar = racUser.signInAvatar;

    /**
    * 微信的OpenId
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> wxOpenId = racUser.wxOpenId;

    /**
    * 微信的UnionId
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> wxUnionId = racUser.wxUnionId;

    /**
    * 微信昵称
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> wxNickname = racUser.wxNickname;

    /**
    * 微信头像
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> wxAvatar = racUser.wxAvatar;

    /**
    * QQ的OpenId
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> qqOpenId = racUser.qqOpenId;

    /**
    * QQ的UnionId
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> qqUnionId = racUser.qqUnionId;

    /**
    * QQ昵称
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> qqNickname = racUser.qqNickname;

    /**
    * QQ头像
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> qqAvatar = racUser.qqAvatar;

    /**
    * 是否测试者
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Boolean> isTester = racUser.isTester;

    /**
    * 建立时间戳
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Long> createrTimestamp = racUser.createrTimestamp;

    /**
    * 修改时间戳
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Long> updateTimestamp = racUser.updateTimestamp;

    public static final class RacUser extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<Long> personId = column("PERSON_ID", JDBCType.BIGINT);

        public final SqlColumn<Boolean> isEnabled = column("IS_ENABLED", JDBCType.BIT);

        public final SqlColumn<String> signInName = column("SIGN_IN_NAME", JDBCType.VARCHAR);

        public final SqlColumn<String> signInMobile = column("SIGN_IN_MOBILE", JDBCType.VARCHAR);

        public final SqlColumn<String> signInEmail = column("SIGN_IN_EMAIL", JDBCType.VARCHAR);

        public final SqlColumn<String> signInPswd = column("SIGN_IN_PSWD", JDBCType.VARCHAR);

        public final SqlColumn<String> signInPswdSalt = column("SIGN_IN_PSWD_SALT", JDBCType.CHAR);

        public final SqlColumn<String> signInNickname = column("SIGN_IN_NICKNAME", JDBCType.VARCHAR);

        public final SqlColumn<String> signInAvatar = column("SIGN_IN_AVATAR", JDBCType.VARCHAR);

        public final SqlColumn<String> wxOpenId = column("WX_OPEN_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> wxUnionId = column("WX_UNION_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> wxNickname = column("WX_NICKNAME", JDBCType.VARCHAR);

        public final SqlColumn<String> wxAvatar = column("WX_AVATAR", JDBCType.VARCHAR);

        public final SqlColumn<String> qqOpenId = column("QQ_OPEN_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> qqUnionId = column("QQ_UNION_ID", JDBCType.VARCHAR);

        public final SqlColumn<String> qqNickname = column("QQ_NICKNAME", JDBCType.VARCHAR);

        public final SqlColumn<String> qqAvatar = column("QQ_AVATAR", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isTester = column("IS_TESTER", JDBCType.BIT);

        public final SqlColumn<Long> createrTimestamp = column("CREATER_TIMESTAMP", JDBCType.BIGINT);

        public final SqlColumn<Long> updateTimestamp = column("UPDATE_TIMESTAMP", JDBCType.BIGINT);

        public RacUser() {
            super("RAC_USER");
        }
    }
}