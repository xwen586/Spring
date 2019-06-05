package demo01;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 演示Spring下使用iBatis
 * 版本：spring-2.5.6.jar; ibatis-2.3.4.jar; commons-logging-1.2.jar
 * 数据库：sqlite-jdbc-3.27.2.jar
 */
public class demoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo01/appContext.xml");

		try {
			CustomerDao dao1 = (CustomerDao) ctx.getBean("customerDao");
			CustomerDaoTmpl dao2 = (CustomerDaoTmpl) ctx.getBean("customerDaoTmpl");
			CustomerDaoSupp dao3 = (CustomerDaoSupp) ctx.getBean("customerDaoSupp");

			Customer c1 = new Customer();
			c1.setId(20);
			c1.setName("iBatis Gump elev");
			c1.setAge(16);
			c1.setPhone("086-1122-005");
			//dao1.insert(c1);
			
			List<Customer> li1 = dao1.selectAll();
			for(Customer c : li1) {
				System.out.println(c.toString());
			}
			System.out.println("-----IBatis Dao Success!-----");
			
			Customer c2 = new Customer();
			c2.setId(20);
			c2.setName("iBatisTmpl Gump twel");
			c2.setAge(16);
			c2.setPhone("086-1132-006");
			//dao2.insert(c2);
			
			List<Customer> li2 = dao2.selectAll();
			for(Customer c : li2) {
				System.out.println(c.toString());
			}
			System.out.println("-----IBatis Dao Template Success!-----");

			Customer c3 = new Customer();
			c3.setId(21);
			c3.setName("iBatisSupp Gump twel");
			c3.setAge(16);
			c3.setPhone("086-1152-006");
			dao3.insert(c3);
			
			List<Customer> li3 = dao3.selectAll();
			for(Customer c : li3) {
				System.out.println(c.toString());
			}
			System.out.println("-----IBatis DaoSupport Success!-----");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
