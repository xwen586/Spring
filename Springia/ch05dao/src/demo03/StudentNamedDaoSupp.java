package demo03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

//Student���ݲ������̳�NamedParameterJdbcDaoSupportģ���࣬������������
//https://zmx.iteye.com/blog/373736
public class StudentNamedDaoSupp extends NamedParameterJdbcDaoSupport {

	//����
	public void save(Student s) {
		//ʹ����������
        String SQL_INS = "insert into Student2(id, name, age) values(null, :sname, :sage);";
        Map params = new HashMap();
        params.put("sname", s.getName());
        params.put("sage", s.getAge());
        this.getNamedParameterJdbcTemplate().update(SQL_INS, params);
    }
	
	//ɾ��
	@SuppressWarnings("unchecked")
	public void delete(Integer id) {
        String SQL_DEL = "delete from Student2 where id = :stud_id; ";
        @SuppressWarnings("rawtypes")
		Map params = new HashMap();
        params.put("stud_id", id);
        this.getNamedParameterJdbcTemplate().update(SQL_DEL, params);
    }
	
	//�޸�
	public void update(Student s) {
        String SQL_UPD = "update Student2 set name=:sname, age=:sage where id=:stud_id;";
        //��ȷ����
        Map<String, String> params = new HashMap<String, String>();
        params.put("stud_id", s.getId().toString());
        params.put("sname", s.getName());
        params.put("sage", String.valueOf(s.getAge()) );
        this.getNamedParameterJdbcTemplate().update(SQL_UPD, params);
    }

	//��ѯ
	public Student getById(Integer id) {
        String SQL_INQ = "select * from Student2 where id=:stud_id;";
        Map<String,Integer> paramMap = new HashMap<>();
	    paramMap.put("stud_id", id);
	    //SqlParameterSource ps=new BeanPropertySqlParameterSource(stu);
	    //return (Stu)namedjdbctemp.queryForObject(sql, ps, new BeanPropertyRowMapper(Stu.class));
	    //RowMapper rm = ParameterizedBeanPropertyRowMapper.newInstance(Student.class);
	    RowMapper rm = new BeanPropertyRowMapper(Student.class);
        return (Student) this.getNamedParameterJdbcTemplate().queryForObject(SQL_INQ, paramMap, rm);
    }
	
	//��ѯ����
	public List<Student> getAll() {
		String sql = "select * from Student2;";
		List list = this.getNamedParameterJdbcTemplate().getJdbcOperations().query(sql,new BeanPropertyRowMapper(Student.class));
		System.out.println("list.size()=" + list.size());
        return list;//.size() > 0 ? list : null;
	}

	public List getAll(Student stu) {
		String sql = "select id as sid, name as sname, age as sage from Student2 where id=:sid";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(stu);
		return this.getNamedParameterJdbcTemplate().query(sql, ps, new BeanPropertyRowMapper(Student.class));
	}

}
