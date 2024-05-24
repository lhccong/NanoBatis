package com.cong.nanobatis.transaction.jdbc;

import com.cong.nanobatis.transaction.Transaction;
import com.cong.nanobatis.transaction.TransactionFactory;
import com.cong.nanobatis.transaction.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

public class JdbcTransactionFactory implements TransactionFactory {
    @Override
    public Transaction newTransaction(Connection conn) {
        return new JdbcTransaction(conn);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit) {
        return new JdbcTransaction(dataSource, level, autoCommit);
    }
}
