package sia2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/* JDBC�������ݿ����ӣ���ʹ��Spring��ܡ��ο� ConventionalJdbcRantDao ��
 * 
 */
public class jdbcApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Motorist m = new Motorist();
		m.setId(10);
		m.setFirstName("Tom");
		m.setLastName("Loo");
		m.setEmail("Tom@gmail.com");
		m.setPassword("password");
		
		jdbcApp test = new jdbcApp();
		test.initConn();
		test.initTable();
		test.saveMotorist(m);

		test.initConn();
		Motorist motorist = test.getMotoristById(10);
		if(motorist == null) System.out.println("Null!");
		motorist.toString();
		System.out.println("M:" + motorist.getFirstName());
	}

	/*����Դ����
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		//SQLiteConnectionPoolDataSource dataSource = new SQLiteConnectionPoolDataSource();
		//dataSource.setUrl("jdbc:sqlite:c:/temp/test.db");
		  DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		    dataSourceBuilder.driverClassName("org.sqlite.JDBC");
		    dataSourceBuilder.url("jdbc:sqlite:" + "example.db");
		    dataSourceBuilder.type(SQLiteDataSource.class);
	      this.dataSource = dataSource;
	}
	*/
	
	//�������ݿ�����ӡ��������Կ������ӳ�
	private Connection connection = null;
	public void initConn() {
		try {
			//�������ݿⷽ�ṩ��jdbc��
			Class.forName("org.sqlite.JDBC");
			
			//"jdbc:sqlite:/sample.db"�����֣����̷���Ŀ¼�������ļ�
			//"jdbc:sqlite:sample.db"�����֣�����Ŀ��Ŀ¼�������ļ�
			Connection connection = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
			
			if(connection == null) System.out.println("Connection Null!");
			this.connection = connection;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//��ʼ����
	public void initTable() {
		try {
			Connection conn = this.connection;
			Statement stat = conn.createStatement();
            stat.executeUpdate("drop table if exists motorist;");
            stat.executeUpdate("create table motorist(id, email, password, firstName, lastName);"); //�������
		}
	      catch (SQLException e) {
	         // deal with exception--somehow
	    	  System.out.println("---- initTable SQLException ----");
	      }
	}
	
	//����JDBC�����ݿ����һ��
	private static final String MOTORIST_INSERT = "insert into motorist (id, email, password, firstName, lastName) "
               + "values (?,?,?,?,?)";
	public void saveMotorist(Motorist motorist) {
	      Connection conn = null;  //���ݿ�����
	      PreparedStatement stmt = null;  //SQL���
	      try {
	         conn = this.connection; //dataSource.getConnection();  //���ݿ�����ʵ��
	         stmt = conn.prepareStatement(MOTORIST_INSERT); //�������

	         //�󶨲���
	         stmt.setInt(1, motorist.getId());
	         stmt.setString(2, motorist.getEmail());
	         stmt.setString(3, motorist.getPassword());
	         stmt.setString(4, motorist.getFirstName());
	         stmt.setString(5, motorist.getLastName());
	         stmt.execute();//ִ�����
	      }
	      catch (SQLException e) {
	         // deal with exception--somehow
	    	  System.out.println("----saveMotorist SQLException ----");
	      }
	      finally {
	    	 //�����Դ
	         try {
	            if(stmt != null) stmt.close();
	            if(conn != null) conn.close();
	         }
	         catch (SQLException e) {}
	      }
	}
	
	   private static final String MOTORIST_SELECT = "select id, email, password, firstName, lastName from motorist";
	   
	   private static final String MOTORIST_QUERY = "select id, email, password, firstName, lastName "
               + " from motorist where id=?";
	   public Motorist getMotoristById(Integer id) {
		      Connection conn = null;
		      PreparedStatement stmt = null;
		      ResultSet rs = null;
		      try {
		         conn = this.connection; //dataSource.getConnection();
		         stmt = conn.prepareStatement(MOTORIST_QUERY);
		         stmt.setInt(1, id);
		         rs = stmt.executeQuery();
		         Motorist motorist = null;
		         if (rs.next()) {
		            motorist = new Motorist();
		            motorist.setId(rs.getInt("id"));
		            motorist.setEmail(rs.getString("email"));
		            motorist.setPassword(rs.getString("password"));
		            motorist.setFirstName(rs.getString("firstName"));
		            motorist.setLastName(rs.getString("lastName"));
		         }
		         return motorist;
		      }
		      catch (SQLException e) {}
		      finally {
		         try {
		            if (rs != null) {
		               rs.close();
		            }
		            if (stmt != null) {
		               stmt.close();
		            }
		            if (conn != null) {
		               conn.close();
		            }
		         }
		         catch (SQLException e) {}
		      }
		      return null;
		   }
}
