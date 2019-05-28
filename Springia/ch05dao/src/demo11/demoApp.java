package demo11;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import demo03.Student;

//
/* 演示Spring集成Hibernate，Hibernate的JDBC模板/命名参数支持/简单JDBC支持
 * 本程序引用: spring2.5.6; jdk1.8; 
 * Hibernate：hibernate3.2.7.jar，dom4j-1.6.1.jar，jta.jar，commons-collections-2.1.1.jar，
 * cglib-2.1.3.jar，asm.jar，antlr-2.7.6.jar
 * 数据库：SQLite3.25.3(单机数据库), sqlite-jdbc-3.27.2.jar
 */
public class demoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo11/appContext.xml");

		CustomerDaoHibTmpl dao1 = (CustomerDaoHibTmpl) ctx.getBean("customerDaoHibTmpl");
		
		Customer c1 = new Customer();
		c1.setId(2);
		c1.setName("Gump elev");
		c1.setAge(16);
		c1.setPhone("086-1122-005");
		//dao1.save(c1);
		
		List<Customer> li = dao1.findAll();
		for(Customer s : li) {
			System.out.println(s.toString());
		}

	}

}
