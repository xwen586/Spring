package d3jmssupp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 使用JMS网关支持类
 * 版本：spring-2.5.6.jar; activemq-all-5.3.2.jar;
 */
public class sendSuppApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d3jmssupp/sndSuppContext.xml");

		sender snd = (sender) ctx.getBean("send");
		snd.sendTextMsg("Hello JMS Template Support!");
		
		System.out.println("-----Message Send Success-----");
	}

}
