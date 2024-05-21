package com.cong.nanobatis.test.dao;

/**
 * 学校 DAO
 *
 * @author cong
 * @date 2024/05/21
 */
public interface SchoolDao {

    /**
     * 查询学校名称
     *
     * @param uId u id
     * @return {@link String }
     */
    String querySchoolName(String uId);

}
