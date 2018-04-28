package com.wesai.user;

import org.apache.ibatis.annotations.Param;

public interface UserPassportDao {
    /**
     * 通过该用户手机号删除其信息
     */
    public void deleteUser(String mobile);

    /**
     * 通过用户手机号获取用户Id
     */
    public String getUserId(String mobile);

    /**
     * 通过用户userid获取到该用户昵称名
     * @param userId 用户编号
     * @return 该用户的昵称
     */
    public String getNameByUId(@Param("userid") String userId);
}

