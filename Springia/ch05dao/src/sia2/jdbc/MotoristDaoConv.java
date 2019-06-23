package sia2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//��ͳ��jdbc���ݷ���
public class MotoristDaoConv {

	private Connection connection = null;// ���ݿ������
	//����JDBC����������Դ
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
	
	// ��ʼ����
	public void initTable() {
		try {
			Connection conn = this.connection;
			Statement stat = conn.createStatement();
			stat.executeUpdate("drop table if exists motorist;");
			stat.executeUpdate("create table motorist(id, email, password, firstName, lastName);"); // �������
		} catch (SQLException e) {
			// deal with exception--somehow
			System.out.println("---- initTable SQLException ----");
			e.printStackTrace();
		}
	}

	//������ ����JDBC�����ݿ����һ��
	private static final String MOTORIST_INSERT = "insert into motorist (id, email, password, firstName, lastName) "
			+ "values (?,?,?,?,?)";

	public void saveMotorist(Motorist motorist) {
		Connection conn = null; // ���ݿ�����
		PreparedStatement stmt = null; // SQL���
		try {
			//�������ݿⷽ�ṩ��jdbc��
			Class.forName("org.sqlite.JDBC");
			//conn = dataSource.getConnection(); //���ݿ�����ʵ��
			conn = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
			stmt = conn.prepareStatement(MOTORIST_INSERT); // �������

			// �󶨲���
			stmt.setInt(1, motorist.getId());
			stmt.setString(2, motorist.getEmail());
			stmt.setString(3, motorist.getPassword());
			stmt.setString(4, motorist.getFirstName());
			stmt.setString(5, motorist.getLastName());
			stmt.execute();// ִ�����
		} catch (SQLException | ClassNotFoundException e) {
			// deal with exception--somehow
			System.out.println("----saveMotorist SQLException ----");
			e.printStackTrace();
		} finally {
			// �����Դ
			try {
				if (stmt != null) {	stmt.close(); }
				if (conn != null) {	conn.close(); }
			} catch (SQLException e) {
			}
		}
	}

	// ��ѯ
	private static final String MOTORIST_QUERY = "select id, email, password, firstName, lastName "
			+ " from motorist where id=?";

	public Motorist getMotoristById(Integer id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
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

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (stmt != null) {	stmt.close(); }
				if (conn != null) {	conn.close(); }
			} catch (SQLException e) {
			}
		}
		return null;
	}

	// �޸�
	private static final String MOTORIST_UPDATE = "update motorist "
			+ "set email=?, password=?, firstName=?, lastName=? " + "where id=?";

	public void updateMotorist(Motorist motorist) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
			stmt = conn.prepareStatement(MOTORIST_UPDATE);
			stmt.setString(1, motorist.getEmail());
			stmt.setString(2, motorist.getPassword());
			stmt.setString(3, motorist.getFirstName());
			stmt.setString(4, motorist.getLastName());
			stmt.setInt(5, motorist.getId());
			stmt.execute();
		} catch (SQLException | ClassNotFoundException e) {
			// deal with exception--somehow
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close(); }
				if (conn != null) {	conn.close(); }
			} catch (SQLException e) {
			}
		}
	}
	
	//ɾ��
	private static final String MOTORIST_DELETE = 
			"delete from motorist where id=?";
	public void deleteMotorist(Motorist motorist) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:bin/sample.db");
			stmt = conn.prepareStatement(MOTORIST_DELETE);
			stmt.setInt(1, motorist.getId());
			stmt.execute();
		} catch (SQLException | ClassNotFoundException e) {
			// deal with exception--somehow
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {	stmt.close(); }
				if (conn != null) {	conn.close(); }
			} catch (SQLException e) {
			}
		}
	}
	
}
