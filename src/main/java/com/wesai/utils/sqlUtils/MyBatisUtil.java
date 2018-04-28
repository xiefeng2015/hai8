package com.wesai.utils.sqlUtils;

import com.wesai.utils.ConfigLocation;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MyBatisUtil {
	
	@Resource
    private static SqlSessionFactory sqlSessionFactory;
	private static ApplicationContext context;
	private SqlSession sqlSession;
	
	public SqlSession getSqlSession() {
		if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession();
        }
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 获取SqlSessionFactory
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory(String environmentId) {
		InputStream is = null;
		String path = "";
		// 加载mybatis的配置文件
		try {
			path = System.getProperty("user.dir") + File.separator 
					+ "resources" + File.separator + "mybatis-config.xml";
			is = new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
		//构建sqlSession的工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is,environmentId);
		return factory;
	}


	/**
	 * 获取SqlSession
	 * @param isAutoCommit
	 *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
	 *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(String environmentId,boolean isAutoCommit) {
		return getSqlSessionFactory(environmentId).openSession(isAutoCommit);
	}
	
	/**
	 * Spring加载SqlSessionFactory
	 */
	public static SqlSessionFactory getSqlSessionFactory(String dataSource, ApplicationContext ctx) {
		try {
			sqlSessionFactory = ctx.getBean("sqlSessionFactory", SqlSessionFactory.class);
			DataSourceHandle.setDataSourceType(dataSource);
		} catch (NoClassDefFoundError e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
	
	/**
	 * 获取getSqlSessionBean
	 * @param dataSource 切换的数据源
	 * @param isAutoCommit 是否自动提交
	 * @return 返回一个SqlSession的对象
	 */
	public static SqlSession getSqlSessionBean(String dataSource,boolean isAutoCommit) {
		if (context == null) {
			context = ConfigLocation.getContextLocation();
		}
		return getSqlSessionFactory(dataSource, context).openSession(isAutoCommit);
	}
}