package com.wesai.user;

import org.apache.ibatis.session.SqlSession;
import com.wesai.user.UserPassportDao;
import com.wesai.DataSourceConst;
import com.wesai.MyBatisUtil;

public class UserDataBaseTest extends MyBatisUtil {
    private static UserPassportDao userPassportDao;
    private static SqlSession sqlSession;
    private static String dbEnvironmentId = DataSourceConst.USERDB;

    /**
     * 通过该用户手机号删除其信息
     */
    public static void deleteUser() {
        sqlSession = getSqlSessionBean(dbEnvironmentId, true);
        userPassportDao = sqlSession.getMapper(UserPassportDao.class);
        userPassportDao.deleteUser("15882066239");
        sqlSession.close();
    }

    /**
     * 通过用户手机号获取用户Id
     */
    public static String getUserId(String str) {
        String userId = "1512549452101000019909";
        try {
            sqlSession = getSqlSessionBean(dbEnvironmentId, true);
            userPassportDao = sqlSession.getMapper(UserPassportDao.class);
            userId = userPassportDao.getUserId(str);
            return userId;
        } finally {
            sqlSession.close();
        }
    }

    /**
     * 通过用户userid获取到该用户昵称名
     * @param str 用户编号
     * @return 该用户的昵称
     */
    public static String getNameByUId(String str) {

        String nickname;
        try {
            sqlSession = getSqlSessionBean(dbEnvironmentId, true);
            userPassportDao = sqlSession.getMapper(UserPassportDao.class);
            nickname = userPassportDao.getNameByUId(str);
            return nickname;
        } finally {
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
//		UserDataBaseTest.deleteUser();
        //UserDataBaseTest.getUserId("15828036672");
        UserDataBaseTest.getNameByUId("1512549452101000019909");
    }
}
