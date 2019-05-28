package demo02;


import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

//Student���ݲ�����ʹ�ü�JDBCģ�壬��ҪJava5����
//https://lehsyh.iteye.com/blog/1579987
public class StudentDao3 {

	private SimpleJdbcTemplate simpleJdbc = null;
	public void setJdbcTmpl(JdbcTemplate jdbcTemplate) {
		//this.jdbcTemplate = jdbcTemplate;
		this.simpleJdbc = new SimpleJdbcTemplate(jdbcTemplate);
	}
	
	//����
	public void save(Student s) {
		String SQL_INS = "insert into Student2(id, name, age) values(null, :name, :age);";
        simpleJdbc.update(SQL_INS, new BeanPropertySqlParameterSource(s));
    }
	
	//ɾ��
	public void delete(Integer id) {
        String SQL_DEL = "delete from Student2 where id = ? ";
        simpleJdbc.update(SQL_DEL, id);
    }
	
	//�޸�
	public void update(Student s) {
        String SQL_UPD = "update Student2 set name=:name, age=:age where id=:id;";
        simpleJdbc.update(SQL_UPD, new BeanPropertySqlParameterSource(s));
    }

	//��ѯ
	public Student getById(Integer id) {
        String SQL_INQ = "select * from Student2 where id = ? ";
        Student s = simpleJdbc.queryForObject(SQL_INQ,
        		ParameterizedBeanPropertyRowMapper.newInstance(Student.class), id );
        return s;
    }
	
	//��ѯ����
	public List<Student> getAll() {
		String sql = "select * from Student2 ";
		@SuppressWarnings("unchecked")
		List<Student> list = (List<Student>) simpleJdbc.query(sql,
        		ParameterizedBeanPropertyRowMapper.newInstance(Student.class));//
		System.out.println("list.size()=" + list.size());
        return list;//.size() > 0 ? list : null;
	}

}
