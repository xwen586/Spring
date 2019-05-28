package demo03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/* 使用JdbcDaoSupport
 * JdbcDaoSupport是 spring框架提供的一个类，该类中定义了一个 JdbcTemplate 对象，
 * 无需注入JdbcTemplate，可以通过getJdbcTemplate()方法直接获取使用.
 * Dao 继承 JdbcDaoSupport 的方式，只能用于基于 XML 的方式，注解用不了。
 */
public class StudentDaoSupp extends JdbcDaoSupport {

	//private JdbcTemplate jdbcTemplate = null;
	//public void setJdbcTmpl(JdbcTemplate jdbcTemplate) {
	//	this.jdbcTemplate = jdbcTemplate;
	//}
	
	//新增
	public void save(Student s) {
        String SQL_INS = "insert into Student values(null,?);";
        this.getJdbcTemplate().update(SQL_INS, 
        		new Object[] {s.getName()});
    }
	
	//删除
	public void delete(Integer id) {
        String SQL_DEL = "delete from Student where id = ? ";
        this.getJdbcTemplate().update(SQL_DEL, 
        		new Object[] {id});
    }
	
	//修改
	public void update(Student s) {
        String SQL_UPD = "update Student set name = ? where id=? ";
        this.getJdbcTemplate().update(SQL_UPD,
        		new Object[] {s.getId(), s.getName()}
        );
    }

	//查询
	public Student getById(Integer id) {
        String SQL_INQ = "select * from Student where id = ? ";
        List matches = this.getJdbcTemplate().query(SQL_INQ,
        		new Object[] {id},
        		new RowMapper(){
            public Object mapRow(ResultSet rs, int arg1)
            		throws SQLException, DataAccessException {
            	Student s = new Student();
                s.setId(rs.getInt(1));
                s.setName(rs.getString(2));
                return s;
                }
            });
        return matches.size() > 0 ? (Student) matches.get(0) : null;
    }
	
	//查询所有
	public List<Student> getAll() {
		String sql = "select * from Student;";
		List<Student> list = this.getJdbcTemplate().query(sql, new RowMapper() {
			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				//System.out.println(arg1 + ") NO:" + s.getId() + "; Name:" + s.getName());
				return s;
			}
		});
		System.out.println("list.size()=" + list.size());
        return list;//.size() > 0 ? list : null;
	}

}
