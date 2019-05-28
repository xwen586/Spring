package demo01;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/* 演示jdbc连接池，C3P0数据源
 * 1)使用javax.sql.DataSource数据库连接池
 * 2)SQLite3.25.3：单机数据库
 */
public class jdbcApp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;   //数据库的连接
		Statement stat = null;   //操作语句
        PreparedStatement prep = null; //预操作语句
		ResultSet rs = null;  //返回

		try {
	
			//创建连接池实例
			ComboPooledDataSource ds = new ComboPooledDataSource();
	
			//ds.setDriverClass("com.mysql.jdbc.Driver");		//设置连接池连接数据库所需的驱动
			//ds.setJdbcUrl("jdbc:mysql://localhost:3306/javaee");//设置链接数据库的URL
			//ds.setUser("root");		//设置连接数据库的用户名
			//ds.setPassword("pass");		//设置连接数据库的密码
			ds.setDriverClass("org.sqlite.JDBC");
			ds.setJdbcUrl("jdbc:sqlite:bin/sample.db");
	
			ds.setMaxPoolSize(10);		//设置连接池的最大连接数
			ds.setMinPoolSize(1);		//设置连接池的最小连接数
			ds.setInitialPoolSize(2);	//设置连接池的初始连接数
			ds.setMaxStatements(20);	//设置连接池的缓存Statement的最大数
			
			conn = ds.getConnection();// 通过数据源获取数据库连接
			if(conn == null) { System.out.println("Connection Null!"); return;}
			
			//创建表
			stat = conn.createStatement();
	        stat.executeUpdate("drop table if exists person;"); //删除已有表
	        stat.executeUpdate("create table person(name, jobs);"); //创建表person(姓名,职业)
	        System.out.println("1) create table person() success!");
	        
	        //插入记录
	        prep = conn.prepareStatement("insert into person values (?, ?);");
	        prep.setString(1, "Gandhi");
	        prep.setString(2, "politics");
	        prep.addBatch();
	        prep.setString(1, "Turing");
	        prep.setString(2, "computers");
	        prep.addBatch();
	        prep.setString(1, "Wittgenstein");
	        prep.setString(2, "smartypants");
	        prep.addBatch();
	        conn.setAutoCommit(false);
	        prep.executeBatch();  //执行
	        conn.setAutoCommit(true);
	        System.out.println("2) insert into person() success!");
	
	        //查询记录
	        rs = stat.executeQuery("select * from person;");
	        while (rs.next()) {
	            System.out.println("name = " + rs.getString("name") +
	            		";  job = " + rs.getString("jobs"));
	        }
	        System.out.println("3) select * from person success!");
	        
	
		} catch (SQLException | PropertyVetoException e) {
			// TODO Auto-generated catch block
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
