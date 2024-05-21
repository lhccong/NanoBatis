package com.cong.nanobatis.mapping;


/**
 * SQL 命令类型
 *
 * @author cong
 * @date 2024/05/21
 */
public enum SqlCommandType {

    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;

}
