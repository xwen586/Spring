package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 演示jdbc传统的最原始的数据库操作
 * 1)数据库 SQLite3.25.3：单机数据库, 引用sqlite-jdbc-3.27.2.jar
 * 2)数据库表创建、Insert、select。
 */
public class jdbcApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;   //数据库的连接
		Statement stat = null;   //操作语句
        PreparedStatement prep = null; //预操作语句
		ResultSet rs = null;  //返回

		try {
			//加载数据库方提供的jdbc类
			Class.forName("org.sqlite.JDBC");
			
			//生成DB连接。 通过DriverManager获取连接,建立和关闭是极其耗费系统资源.
			//conn = DriverManager.getConnection("jdbc:mysql://MyDBServer?user=xxx&password=xxx");
			//"jdbc:sqlite:/sample.db"连接字，在盘符根目录下生成文件
			//"jdbc:sqlite:sample.db"连接字，在项目根目录下生成文件
			conn = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
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
            

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
