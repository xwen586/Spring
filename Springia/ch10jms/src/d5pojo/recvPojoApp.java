package d5pojo;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* ʹ��JMSģ����
 * �汾��spring-2.5.6.jar; activemq-all-5.3.2.jar;
 */
public class recvPojoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("d5pojo/rcvPojoContext.xml");

		//MessageConsumer messageConsumer;

		try {
			//�������ӳ��˳�������ѭ����ȷ��������Ϣ��
			for(int i=5; i>0; i--) {
			    //messageConsumer.setMessageListener(new Listener1());
				Thread.sleep(5000);
				System.out.println("waiting " + i + "...");
			}
			//while(true) {}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
