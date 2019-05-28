package demo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/* 演示jdbc连接池，JNDI应用，在Web环境中应用
 * 1)使用javax.sql.DataSource数据库连接池,DataSource只是一个接口，该接口通常由商用服务器等提供实现
 * 2)数据库连接池：
 * 1、 JNDI - 由相应的web服务器中使用。https://www.cnblogs.com/lh-V/p/4064393.html
 * 2、 C3p0 - c3p0-0.9.xx.jar
 * 3、 Apache的Jakarta DBCP
 * 4、 BoneCP
 */
public class jdbcApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main!");
		Connection conn = null;   //数据库的连接
		Statement stat = null;   //操作语句
        PreparedStatement prep = null; //预操作语句
		ResultSet rs = null;  //返回

		try {
			System.out.println("jdbc/sqlconnpool");
			//Hashtable environment = new Hashtable();
			String dataSourceName = "jdbc/sqlconnpool";
			
			//强制设置系统环境，https://westboy172887564.iteye.com/blog/1876619
			//System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
			//System.setProperty(Context.PROVIDER_URL, "rmi://localhost:1099");
			//DataSource可以通过new来取得，但通常是通过 JNDI 用 lookup 取得。
			//JDBC 数据源引用在java:comp/env/jdbc 子上下文中声明 
			//JMS 连接工厂在java:comp/env/jms 子上下文中声明
			Context ctx  = new InitialContext(); //InitialContext要在Web服务器的上下文里才有用
			System.out.println("InitialContext!");
			//java:comp/env/是一个J2EE环境的定义,main函数使用不了
	        //DataSource ds = (DataSource)ctx.lookup("java:comp/env/" + dataSourceName);
			
	        //借用Spring的数据源类
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.sqlite.JDBC");
	        dataSource.setUrl("jdbc:sqlite:bin/sample.db");
	        //dataSource.setUsername("root");
	        //dataSource.setPassword("123456");
	        conn = dataSource.getConnection();//获得连接
			if(conn == null) { System.out.println("Connection Null!"); return;}
			
			//创建表
			stat = conn.createStatement();
	        stat.executeUpdate("drop table if exists person2;"); //删除已有表
	        stat.executeUpdate("create table person2(name, jobs);"); //创建表person(姓名,职业)
	        System.out.println("1) create table person2() success!");

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("获取数据源对象出错！");
			e.printStackTrace();
		}finally {
	    	//清除资源
	        try {
	            if(rs != null) rs.close();
	            if(prep != null) prep.close();
	            if(stat != null) stat.close();
	            if(conn != null) conn.close();
	        }
	        catch (SQLException e) {}
		}
	}

}
