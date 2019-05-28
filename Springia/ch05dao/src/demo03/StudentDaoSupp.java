package demo03;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/* ʹ��JdbcDaoSupport
 * JdbcDaoSupport�� spring����ṩ��һ���࣬�����ж�����һ�� JdbcTemplate ����
 * ����ע��JdbcTemplate������ͨ��getJdbcTemplate()����ֱ�ӻ�ȡʹ��.
 * Dao �̳� JdbcDaoSupport �ķ�ʽ��ֻ�����ڻ��� XML �ķ�ʽ��ע���ò��ˡ�
 */
public class StudentDaoSupp extends JdbcDaoSupport {

	//private JdbcTemplate jdbcTemplate = null;
	//public void setJdbcTmpl(JdbcTemplate jdbcTemplate) {
	//	this.jdbcTemplate = jdbcTemplate;
	//}
	
	//����
	public void save(Student s) {
        String SQL_INS = "insert into Student values(null,?);";
        this.getJdbcTemplate().update(SQL_INS, 
        		new Object[] {s.getName()});
    }
	
	//ɾ��
	public void delete(Integer id) {
        String SQL_DEL = "delete from Student where id = ? ";
        this.getJdbcTemplate().update(SQL_DEL, 
        		new Object[] {id});
    }
	
	//�޸�
	public void update(Student s) {
        String SQL_UPD = "update Student set name = ? where id=? ";
        this.getJdbcTemplate().update(SQL_UPD,
        		new Object[] {s.getId(), s.getName()}
        );
    }

	//��ѯ
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
	
	//��ѯ����
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