package com.cong.nanobatis.session;

/**
 * 工厂模式接口，构建 SqlSession 的工厂
 *
 * @author cong
 * @date 2024/05/21
 */
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
   SqlSession openSession();

}