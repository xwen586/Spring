package demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* ��ʾjdbc��ͳ����ԭʼ�����ݿ����
 * 1)���ݿ� SQLite3.25.3���������ݿ�, ����sqlite-jdbc-3.27.2.jar
 * 2)���ݿ������Insert��select��
 */
public class jdbcApp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;   //���ݿ������
		Statement stat = null;   //�������
        PreparedStatement prep = null; //Ԥ�������
		ResultSet rs = null;  //����

		try {
			//�������ݿⷽ�ṩ��jdbc��
			Class.forName("org.sqlite.JDBC");
			
			//����DB���ӡ� ͨ��DriverManager��ȡ����,�����͹ر��Ǽ���ķ�ϵͳ��Դ.
			//conn = DriverManager.getConnection("jdbc:mysql://MyDBServer?user=xxx&password=xxx");
			//"jdbc:sqlite:/sample.db"�����֣����̷���Ŀ¼�������ļ�
			//"jdbc:sqlite:sample.db"�����֣�����Ŀ��Ŀ¼�������ļ�
			conn = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
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
            

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
