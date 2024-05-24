package com.cong.nanobatis.datasource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 数据源工厂
 *
 * @author cong
 * @date 2024/05/24
 */
public interface DataSourceFactory {

    /**
     * 设置属性
     *
     * @param props 道具
     */
    void setProperties(Properties props);

    /**
     * 获取数据源
     *
     * @return {@link DataSource }
     */
    DataSource getDataSource();

}