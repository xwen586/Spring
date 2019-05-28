package demo03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* ��ʾSpring��JDBC��DAO֧���࣬�Դ�JDBCģ��/��������֧��/��JDBC֧��
 * ����������: spring2.5.6; jdk1.8; 
 * ���ݿ⣺SQLite3.25.3(�������ݿ�), sqlite-jdbc-3.27.2.jar
 */
public class demoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo03/appContext.xml");

		//JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		StudentDaoSupp dao1 = (StudentDaoSupp) ctx.getBean("studDaoSupp");
		StudentNamedDaoSupp dao2 = (StudentNamedDaoSupp) ctx.getBean("studNamedDaoSupp");
		StudentSimpleDaoSupp dao3 = (StudentSimpleDaoSupp) ctx.getBean("studSimpleDaoSupp");

		Student s1 = new Student();
		s1.setId(12);
		s1.setName("Support Gamp six");
		s1.setAge(16);
		//dao1.save(s1);
		
		List<Student> li = dao1.getAll();
		for(Student s : li) {
			System.out.println(s.toString());
		}
		
		//ʹ����������DAO��
		System.out.println("-----NamedParameterJdbcDaoSupport-----");
		Student s2 = new Student();
		s2.setId(12);
		s2.setName("Support Gand Teed");
		s2.setAge(18);
		//dao2.save(s2);

		List<Student> li2 = dao2.getAll();
		for(Student s : li2) {
			System.out.println(s.toString());
		}

		//��JDBC��DAO��
		System.out.println("-----SimpleJdbcDaoSupport-----");
		Student s3 = new Student();
		s3.setId(13);
		s3.setName("Support Gump Terlan");
		s3.setAge(19);
		//dao3.save(s3);

		List<Student> li3 = dao3.getAll();
		for(Student s : li3) {
			System.out.println(s.toString());
		}

	}

}
