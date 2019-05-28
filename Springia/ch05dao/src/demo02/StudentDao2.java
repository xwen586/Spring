package demo02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

//Student数据操作，使用NamedParameterJdbcTemplate模板类，命名参数操作
//https://zmx.iteye.com/blog/373736
public class StudentDao2 {

	//JdbcTemplate不支持命名参数，使用NamedParameterJdbcTemplate模板类
	private NamedParameterJdbcTemplate nameJdbc = null;
	public void setJdbcTmpl(JdbcTemplate jdbcTemplate) {
		//直接在xml配置Bean，会报错，采用如下引入模板方式。
		//NamedParameterJdbcTemplate实例，在NamedParameterJdbcTemplate 构造器中直接传入JdbcTemplate的实例
		this.nameJdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
	}
	
	//新增
	public void save(Student s) {
		//使用命名参数
        String SQL_INS = "insert into Student2(id, name, age) values(null, :sname, :age);";
        Map params = new HashMap();
        params.put("sname", s.getName());
        params.put("age", s.getAge());
        nameJdbc.update(SQL_INS, params);
    }
	
	//删除
	@SuppressWarnings("unchecked")
	public void delete(Integer id) {
        String SQL_DEL = "delete from Student2 where id = :stud_id; ";
        @SuppressWarnings("rawtypes")
		Map params = new HashMap();
        params.put("stud_id", id);
        nameJdbc.update(SQL_DEL, params);
    }
	
	//修改
	public void update(Student s) {
        String SQL_UPD = "update Student2 set name=:sname, age=:sage where id=:stud_id;";
        //明确类型
        Map<String, String> params = new HashMap<String, String>();
        params.put("stud_id", s.getId().toString());
        params.put("sname", s.getName());
        params.put("sage", String.valueOf(s.getAge()) );
        nameJdbc.update(SQL_UPD, params);
    }

	//查询
	public Student getById(Integer id) {
        String SQL_INQ = "select * from Student2 where id=:stud_id;";
        Map<String,Integer> paramMap = new HashMap<>();
	    paramMap.put("stud_id", id);
	    //SqlParameterSource ps=new BeanPropertySqlParameterSource(stu);
	    //return (Stu)namedjdbctemp.queryForObject(sql, ps, new BeanPropertyRowMapper(Stu.class));
	    //RowMapper rm = ParameterizedBeanPropertyRowMapper.newInstance(Student.class);
	    RowMapper rm = new BeanPropertyRowMapper(Student.class);
        return (Student) nameJdbc.queryForObject(SQL_INQ, paramMap, rm);
    }
	
	//查询所有
	public List<Student> getAll() {
		String sql = "select * from Student2;";
		List list = nameJdbc.getJdbcOperations().query(sql,new BeanPropertyRowMapper(Student.class));
		System.out.println("list.size()=" + list.size());
        return list;//.size() > 0 ? list : null;
	}

	public List getAll(Student stu) {
		String sql = "select id as sid, name as sname, age as sage from Student2 where id=:sid";
		SqlParameterSource ps = new BeanPropertySqlParameterSource(stu);
		return nameJdbc.query(sql, ps, new BeanPropertyRowMapper(Student.class));
	}

}
