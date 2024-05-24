package com.cong.nanobatis.transaction;

import java.sql.Connection;

/**
 * 事务隔离级别
 *
 * @author cong
 * @date 2024/05/24
 */
public enum TransactionIsolationLevel {

    /**
     * 没有
     */
    NONE(Connection.TRANSACTION_NONE),
    /**
     * 读取已提交
     */
    READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),
    /**
     * 读取未提交
     */
    READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),
    /**
     * 可重复读取
     */
    REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),
    /**
     * 序列 化
     */
    SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

    private final int level;

    TransactionIsolationLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
