package sia2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/* JDBC操作数据库例子，不使用Spring框架。参考 ConventionalJdbcRantDao 类
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

	/*数据源定义
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
	
	//生成数据库的连接。后续可以考虑连接池
	private Connection connection = null;
	public void initConn() {
		try {
			//加载数据库方提供的jdbc类
			Class.forName("org.sqlite.JDBC");
			
			//"jdbc:sqlite:/sample.db"连接字，在盘符根目录下生成文件
			//"jdbc:sqlite:sample.db"连接字，在项目根目录下生成文件
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
	
	//初始化表
	public void initTable() {
		try {
			Connection conn = this.connection;
			Statement stat = conn.createStatement();
            stat.executeUpdate("drop table if exists motorist;");
            stat.executeUpdate("create table motorist(id, email, password, firstName, lastName);"); //创建语句
		}
	      catch (SQLException e) {
	         // deal with exception--somehow
	    	  System.out.println("---- initTable SQLException ----");
	      }
	}
	
	//利用JDBC在数据库插入一行
	private static final String MOTORIST_INSERT = "insert into motorist (id, email, password, firstName, lastName) "
               + "values (?,?,?,?,?)";
	public void saveMotorist(Motorist motorist) {
	      Connection conn = null;  //数据库连接
	      PreparedStatement stmt = null;  //SQL语句
	      try {
	         conn = this.connection; //dataSource.getConnection();  //数据库连接实例
	         stmt = conn.prepareStatement(MOTORIST_INSERT); //创建语句

	         //绑定参数
	         stmt.setInt(1, motorist.getId());
	         stmt.setString(2, motorist.getEmail());
	         stmt.setString(3, motorist.getPassword());
	         stmt.setString(4, motorist.getFirstName());
	         stmt.setString(5, motorist.getLastName());
	         stmt.execute();//执行语句
	      }
	      catch (SQLException e) {
	         // deal with exception--somehow
	    	  System.out.println("----saveMotorist SQLException ----");
	      }
	      finally {
	    	 //清除资源
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
