package d1jms;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/* ʹ��ActiveMQ��JMS����Ϣ���ճ��򡣴�ͳJMS���룬δʹ��Spring�����
 * ���������activemq-all-5.3.2.jar; 
 * ActiveMQ 5.15.9�ַ�����activemq start  
 * Web���� http://localhost:8161/  �鿴������Ϣ
 */
public class recvApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory cfac = null;
		Connection conn = null;   //��Ϣ������
		Session sess = null; //�Ự

		try {
			cfac = new ActiveMQConnectionFactory("tcp://localhost:61616");
			conn  = cfac.createConnection(); //��������
			sess  = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//ѡ�����
			Destination dest = new ActiveMQQueue("myQueue"); //
			//������Ϣ
			MessageConsumer consumer = sess.createConsumer(dest);
			conn.start();
			
			Message msg = consumer.receive();
			TextMessage txt = (TextMessage)msg;
			
			System.out.println("Get Message: " + txt.getText() );
			
		} catch(JMSException e) {
			e.printStackTrace();
		} finally {
	    	//�����Դ
	        try {
	            if(sess != null) sess.close();
	            if(conn != null) conn.close();
	        }
	        catch (JMSException ex) {ex.printStackTrace();}
		}
	}

}
