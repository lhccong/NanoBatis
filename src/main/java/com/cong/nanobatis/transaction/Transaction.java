package com.cong.nanobatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 事务接口
 *
 * @author cong
 * @date 2024/05/24
 */
public interface Transaction {

    /**
     * 获取连接
     *
     * @return {@link Connection }
     * @throws SQLException sql异常
     */
    Connection getConnection() throws SQLException;

    /**
     * 提交
     *
     * @throws SQLException sql异常
     */
    void commit() throws SQLException;

    /**
     * 回滚
     *
     * @throws SQLException sql异常
     */
    void rollback() throws SQLException;

    /**
     * 关闭
     *
     * @throws SQLException sql异常
     */
    void close() throws SQLException;

}
