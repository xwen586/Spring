package d2jmstmpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 使用JMS模板类
 * 版本：spring-2.5.6.jar; activemq-all-5.3.2.jar;
 */
public class sendApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d2jmstmpl/sndContext.xml");

		sender snd = (sender) ctx.getBean("send");
		snd.sendTextMsg("Hello JMS Template !");
		
		System.out.println("-----Message Send Success-----");
	}

}
