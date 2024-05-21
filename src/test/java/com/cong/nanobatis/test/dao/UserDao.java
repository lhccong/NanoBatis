package com.cong.nanobatis.test.dao;

/**
 * 用户 DAO
 *
 * @author cong
 * @date 2024/05/21
 */
public interface UserDao {
    /**
     * 查询用户名
     *
     * @param uId u id
     * @return {@link String }
     */
    String queryUserName(String uId);

    /**
     * 查询用户年龄
     *
     * @param uId u id
     * @return {@link Integer }
     */
    Integer queryUserAge(String uId);
}
