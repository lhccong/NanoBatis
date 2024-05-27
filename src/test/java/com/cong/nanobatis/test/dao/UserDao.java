package com.cong.nanobatis.test.dao;

import com.cong.nanobatis.test.po.User;

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
    User queryUserInfoById(Long uId);
}
