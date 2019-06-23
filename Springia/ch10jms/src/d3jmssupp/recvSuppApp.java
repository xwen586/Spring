package d3jmssupp;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 使用JMS网关支持类
 * 版本：spring-2.5.6.jar; activemq-all-5.3.2.jar;
 */
public class recvSuppApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d3jmssupp/rcvSuppContext.xml");

		receiver rcv = (receiver) ctx.getBean("rcver");

		try {

			TextMessage txt = rcv.recvTextMsg();
			
			System.out.println("Get Message:" + txt.getText() );
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
