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

/* ��ʾjdbc���ӳأ�JNDIӦ�ã���Web������Ӧ��
 * 1)ʹ��javax.sql.DataSource���ݿ����ӳ�,DataSourceֻ��һ���ӿڣ��ýӿ�ͨ�������÷��������ṩʵ��
 * 2)���ݿ����ӳأ�
 * 1�� JNDI - ����Ӧ��web��������ʹ�á�https://www.cnblogs.com/lh-V/p/4064393.html
 * 2�� C3p0 - c3p0-0.9.xx.jar
 * 3�� Apache��Jakarta DBCP
 * 4�� BoneCP
 */
public class jdbcApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main!");
		Connection conn = null;   //���ݿ������
		Statement stat = null;   //�������
        PreparedStatement prep = null; //Ԥ�������
		ResultSet rs = null;  //����

		try {
			System.out.println("jdbc/sqlconnpool");
			//Hashtable environment = new Hashtable();
			String dataSourceName = "jdbc/sqlconnpool";
			
			//ǿ������ϵͳ������https://westboy172887564.iteye.com/blog/1876619
			//System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
			//System.setProperty(Context.PROVIDER_URL, "rmi://localhost:1099");
			//DataSource����ͨ��new��ȡ�ã���ͨ����ͨ�� JNDI �� lookup ȡ�á�
			//JDBC ����Դ������java:comp/env/jdbc �������������� 
			//JMS ���ӹ�����java:comp/env/jms ��������������
			Context ctx  = new InitialContext(); //InitialContextҪ��Web���������������������
			System.out.println("InitialContext!");
			//java:comp/env/��һ��J2EE�����Ķ���,main����ʹ�ò���
	        //DataSource ds = (DataSource)ctx.lookup("java:comp/env/" + dataSourceName);
			
	        //����Spring������Դ��
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("org.sqlite.JDBC");
	        dataSource.setUrl("jdbc:sqlite:bin/sample.db");
	        //dataSource.setUsername("root");
	        //dataSource.setPassword("123456");
	        conn = dataSource.getConnection();//�������
			if(conn == null) { System.out.println("Connection Null!"); return;}
			
			//������
			stat = conn.createStatement();
	        stat.executeUpdate("drop table if exists person2;"); //ɾ�����б�
	        stat.executeUpdate("create table person2(name, jobs);"); //������person(����,ְҵ)
	        System.out.println("1) create table person2() success!");

		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ����Դ�������");
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
