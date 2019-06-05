package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 演示jdbc连接HSqlDB实例
 * 1)
 */
public class jdbcHsqlApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stat = null;   //操作语句
		PreparedStatement prep = null; //预操作语句
		ResultSet rs = null;  //返回

		try {
            Class.forName("org.hsqldb.jdbcDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:file:bin/sample.hdb", "sa", "");
			if(conn == null) { System.out.println("Connection Null!"); return;}
            System.out.println("Connected hsqldb success!");
			
            //创建表
			stat = conn.createStatement();
            stat.executeUpdate("drop table if exists person;"); //删除已有表
            String DDL = "create table person(id INTEGER, name VARCHAR(20), birthday DATE, jobs VARCHAR(20));";
            stat.executeUpdate(DDL); //创建表person(姓名,职业)
            System.out.println("1) create table person() success!");

            //插入记录
            prep = conn.prepareStatement("insert into person values (?, ?, SYSDATE, ?);");
            prep.setInt(1, 11);
            prep.setString(2, "Gandhi");
            prep.setString(3, "politics");
            prep.addBatch();
            prep.setInt(1, 12);
            prep.setString(2, "Turing");
            prep.setString(3, "computers");
            prep.addBatch();
            prep.setInt(1, 13);
            prep.setString(2, "Wittgenstein");
            prep.setString(3, "smartypants");
            prep.addBatch();
            conn.setAutoCommit(false);
            prep.executeBatch();  //执行
            conn.setAutoCommit(true);
            
            //查询记录
            rs = stat.executeQuery("select * from person;");
            while (rs.next()) {
                System.out.println("name = " + rs.getString("name") +
                		";  job = " + rs.getString("jobs"));
            }
            System.out.println("3) select * from person success!");

        } catch(Exception e) {
            System.out.println("ERROR:failed to load HSQLDB JDBC driver.");
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
		return;
	}

}
