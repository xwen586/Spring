package demo01;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/* ��ʾjdbc���ӳأ�C3P0����Դ
 * 1)ʹ��javax.sql.DataSource���ݿ����ӳ�
 * 2)SQLite3.25.3���������ݿ�
 */
public class jdbcApp4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;   //���ݿ������
		Statement stat = null;   //�������
        PreparedStatement prep = null; //Ԥ�������
		ResultSet rs = null;  //����

		try {
	
			//�������ӳ�ʵ��
			ComboPooledDataSource ds = new ComboPooledDataSource();
	
			//ds.setDriverClass("com.mysql.jdbc.Driver");		//�������ӳ��������ݿ����������
			//ds.setJdbcUrl("jdbc:mysql://localhost:3306/javaee");//�����������ݿ��URL
			//ds.setUser("root");		//�����������ݿ���û���
			//ds.setPassword("pass");		//�����������ݿ������
			ds.setDriverClass("org.sqlite.JDBC");
			ds.setJdbcUrl("jdbc:sqlite:bin/sample.db");
	
			ds.setMaxPoolSize(10);		//�������ӳص����������
			ds.setMinPoolSize(1);		//�������ӳص���С������
			ds.setInitialPoolSize(2);	//�������ӳصĳ�ʼ������
			ds.setMaxStatements(20);	//�������ӳصĻ���Statement�������
			
			conn = ds.getConnection();// ͨ������Դ��ȡ���ݿ�����
			if(conn == null) { System.out.println("Connection Null!"); return;}
			
			//������
			stat = conn.createStatement();
	        stat.executeUpdate("drop table if exists person;"); //ɾ�����б�
	        stat.executeUpdate("create table person(name, jobs);"); //������person(����,ְҵ)
	        System.out.println("1) create table person() success!");
	        
	        //�����¼
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
	        prep.executeBatch();  //ִ��
	        conn.setAutoCommit(true);
	        System.out.println("2) insert into person() success!");
	
	        //��ѯ��¼
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
	    	//�����Դ
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
