package demo01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

/* ��ʾjdbc���ӳأ�DBCP����Դ
 * 1)ʹ��commons-dbcp2-2.6.0.jar ���ݿ����ӳ�, ����commons-pool2-2.6.2.jar, commons-logging-1.2.jar
 * 2)SQLite3.25.3���������ݿ�
 */
public class jdbcApp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;   //���ݿ������
		Statement stat = null;   //�������
        PreparedStatement prep = null; //Ԥ�������
		ResultSet rs = null;  //����

		try {
	
			//��������Դ����
			BasicDataSource ds = new BasicDataSource();
	
			/*ds.setDriverClassName("com.mysql.jdbc.Driver");		//�������ӳ����������
			ds.setUrl("jdbc:mysql://localhost:3306/javaee");	//�����������ݿ��URL
			ds.setUsername("root");		//�����������ݿ���û���
			ds.setPassword("pass");		//�����������ݿ������  */
			ds.setDriverClassName("org.sqlite.JDBC");
			ds.setUrl("jdbc:sqlite:bin/sample.db");
	
			ds.setInitialSize(2);	//�������ӳصĳ�ʼ������
			ds.setMaxTotal(10); //�������ӳ������ж��ٸ����������setMaxActive(20);	
			//ds.setMinTdle(2);	//�������ӳ����������������е�����
			
			conn = ds.getConnection();// ͨ������Դ��ȡ���ݿ�����
			if(conn == null) { System.out.println("Connection Null!"); return;}
			
			//������
			stat = conn.createStatement();
	        stat.executeUpdate("drop table if exists person;"); //ɾ�����б�
	        stat.executeUpdate("create table person(name, jobs);"); //������person(����,ְҵ)
	        System.out.println("1) create table person() success!");
	        
	        //�����¼
	        prep = conn.prepareStatement("insert into person values (?, ?);");
	        prep.setString(1, "Gandalf");
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
	        
	
		} catch (SQLException e) {
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
