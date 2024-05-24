package com.cong.nanobatis.builder;


import com.cong.nanobatis.session.Configuration;
import com.cong.nanobatis.type.TypeAliasRegistry;


/**
 * 构建器的基类，建造者模式
 *
 * @author cong
 * @date 2024/05/21
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    protected BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = this.configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
