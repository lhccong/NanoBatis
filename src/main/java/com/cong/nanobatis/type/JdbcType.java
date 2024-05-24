package com.cong.nanobatis.type;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;


/**
 * JDBC类型枚举
 *
 * @author cong
 * @date 2024/05/24
 */
public enum JdbcType {

    /**
     * 整数
     */
    INTEGER(Types.INTEGER),
    /**
     * 浮点
     */
    FLOAT(Types.FLOAT),
    /**
     *  双精度浮点
     */
    DOUBLE(Types.DOUBLE),
    /**
     * 十进制
     */
    DECIMAL(Types.DECIMAL),
    /**
     * 字符
     */
    VARCHAR(Types.VARCHAR),
    /**
     * 时间戳
     */
    TIMESTAMP(Types.TIMESTAMP);

    public final int typeCode;
    private static final Map<Integer,JdbcType> codeLookup = new HashMap<>();

    // 就将数字对应的枚举型放入 HashMap
    static {
        for (JdbcType type : JdbcType.values()) {
            codeLookup.put(type.typeCode, type);
        }
    }

    JdbcType(int code) {
        this.typeCode = code;
    }

    public static JdbcType forCode(int code)  {
        return codeLookup.get(code);
    }

}
