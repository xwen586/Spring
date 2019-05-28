package demo02;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* ��ʾSpring�л���JDBCģ��
 * ����������: spring2.5.6; jdk1.8; 
 * ���ݿ⣺SQLite3.25.3(�������ݿ�), sqlite-jdbc-3.27.2.jar
 */
public class demoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo02/appContext.xml");

		//JdbcTemplate jdbcTemplate=(JdbcTemplate) ctx.getBean("jdbcTemplate");
		StudentDao1 dao1 = (StudentDao1) ctx.getBean("studDao1");
		StudentDao2 dao2 = (StudentDao2) ctx.getBean("studDao2");
		StudentDao3 dao3 = (StudentDao3) ctx.getBean("studDao3");
		
		Student s1 = new Student();
		s1.setId(12);
		s1.setName("Gamp five");
		s1.setAge(15);
		//dao1.save(s1);
		
		List<Student> li = dao1.getAll();
		for(Student s : li) {
			System.out.println(s.toString());
		}
		
		//ʹ����������
		System.out.println("-----NamedParameterJdbcTemplate-----");
		Student s2 = new Student();
		s2.setId(12);
		s2.setName("Gand Teed");
		s2.setAge(15);
		//dao2.save(s2);

		List<Student> li2 = dao2.getAll();
		for(Student s : li2) {
			System.out.println(s.toString());
		}

		//��JDBC
		System.out.println("-----SimpleJdbcTemplate-----");
		Student s3 = new Student();
		s3.setId(13);
		s3.setName("Gump Terlan");
		s3.setAge(16);
		//dao3.save(s3);

		List<Student> li3 = dao3.getAll();
		for(Student s : li3) {
			System.out.println(s.toString());
		}

	}

}
