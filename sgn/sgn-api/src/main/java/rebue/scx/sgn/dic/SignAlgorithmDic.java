package rebue.scx.sgn.dic;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import rebue.robotech.dic.Dic;
import rebue.robotech.dic.DicUtils;

/**
 * 签名算法的字典
 * 1: MD5
 * 2. WX_PAY
 * 3: SM3_WITH_SM2
 */
@AllArgsConstructor
@Getter
public enum SignAlgorithmDic implements Dic {
    /**
     * 1: 通用签名
     */
    MD5((byte) 1, "MD5签名"),
    /**
     * 2: 微信支付签名
     */
    WX_PAY((byte) 2, "微信支付签名"),
    /**
     * 3: Sm3WithSm2签名
     */
    SM3_WITH_SM2((byte) 3, "Sm3WithSm2签名");

    private final byte   code;
    private final String desc;

    @Override
    public String getName() {
        return name();
    }

    /**
     * springdoc显示枚举说明将会调用此方法
     */
    @Override
    public String toString() {
        return getCode() + "-" + getName() + "(" + getDesc() + ")";
    }

    /**
     * 通过code得到枚举的实例(Jackson反序列化时会调用此方法)
     * 注意：此方法必须是static的方法，且返回类型必须是本枚举类，而不能是接口Dic
     * 否则Jackson将调用默认的反序列化方法，而不会调用本方法
     */
    @JsonCreator // Jackson在反序列化时，调用 @JsonCreator 标注的构造器或者工厂方法来创建对象
    public static SignAlgorithmDic getItem(final byte pcode) {
        final SignAlgorithmDic result = (SignAlgorithmDic) DicUtils.getItem(SignAlgorithmDic.class, pcode);
        if (result == null) {
            throw new IllegalArgumentException("输入的code(" + pcode + ")不在枚举的取值范围内");
        }
        return result;
    }

}
