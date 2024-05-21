package com.cong.nanobatis.session;

import com.cong.nanobatis.builder.xml.XMLConfigBuilder;
import com.cong.nanobatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * 构建 SqlSessionFactory 的工厂
 *
 * @author cong
 * @date 2024/05/21
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }
}
