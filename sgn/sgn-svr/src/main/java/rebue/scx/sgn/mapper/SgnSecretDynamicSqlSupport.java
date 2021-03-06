package rebue.scx.sgn.mapper;

import java.sql.JDBCType;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SgnSecretDynamicSqlSupport {
    /**
    * @mbg.generated 自动生成，如需修改，请删除本行
     */
    public static final SgnSecret sgnSecret = new SgnSecret();

    /**
    * ID 一般会设置为OrgID
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Long> id = sgnSecret.id;

    /**
    * 密钥
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<String> secret = sgnSecret.secret;

    /**
    * 算法
    *
    * @mbg.generated 自动生成，如需修改，请删除本行
    */
    public static final SqlColumn<Byte> algorithm = sgnSecret.algorithm;

    public static final class SgnSecret extends SqlTable {
        public final SqlColumn<Long> id = column("ID", JDBCType.BIGINT);

        public final SqlColumn<String> secret = column("SECRET", JDBCType.VARCHAR);

        public final SqlColumn<Byte> algorithm = column("ALGORITHM", JDBCType.TINYINT);

        public SgnSecret() {
            super("SGN_SECRET");
        }
    }
}