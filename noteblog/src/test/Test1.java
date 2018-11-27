package test;



import java.io.InputStream;

import mapper.UserDao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import bean.User;

public class Test1 {
	@Test
	public void insert() throws Exception{
		//1.加载配置文件，使用Mybatis框架的SqlSessionFactoryBuilder类
		//构造一个SessionFactory
		InputStream is = Test1.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		//2.通过SessionFactory获取Session对象(1.获取到了连接conn 2.事务开启：自动提交)
		SqlSession session = sessionFactory.openSession(true);
		//3.通过session对象操作数据库
		String sql= "mapper.userDao.insertUser";
	//	User user = new User("690@qq.com","nick","123456");
		//Object obj = session.insert(sql, user);
		//System.out.println(obj);
	} 
}
