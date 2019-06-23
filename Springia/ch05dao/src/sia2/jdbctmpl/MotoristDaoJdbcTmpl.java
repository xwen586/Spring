package sia2.jdbctmpl;

import org.springframework.jdbc.core.JdbcTemplate;

//spring的JdbcTemplate实例
public class MotoristDaoJdbcTmpl {

	private JdbcTemplate jdbcTemplate = null;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 新增： 利用JDBC在数据库插入一行
	private static final String MOTORIST_INSERT =
			"insert into motorist (id, email, password, firstName, lastName) "
			+ "values (?,?,?,?,?)";

	public void saveMotorist(Motorist motorist) {
		this.jdbcTemplate.update(MOTORIST_INSERT, 
				new Object[] { motorist.getEmail(), motorist.getPassword(),
				motorist.getFirstName(), motorist.getLastName() });
	}
}
