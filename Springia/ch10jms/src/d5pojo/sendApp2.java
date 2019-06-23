package d5pojo;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/* ʹ��ActiveMQ��JMS����Ϣ���ͳ��򡣴�ͳJMS���룬δʹ��Spring�����
 * ���������activemq-all-5.3.2.jar; 
 * ActiveMQ 5.15.9�ַ�����activemq start  
 * Web���� http://localhost:8161/  �鿴������Ϣ
 */
public class sendApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory connf = null;
		Connection conn = null;   //��Ϣ������
		Session sess = null; //�Ự

		try {
			connf = new ActiveMQConnectionFactory("tcp://localhost:61616");
			conn  = connf.createConnection(); //��������
			sess  = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//��������
			Destination dest = new ActiveMQQueue("purePojo"); //
			//������Ϣ
			MessageProducer producer = sess.createProducer(dest);
			//TextMessage msg = sess.createTextMessage();
			//msg.setText("Hello JMS World! with MDP.");
			//��ֵ����Ϣ  
			MapMessage mapMessage = sess.createMapMessage();
			mapMessage.setInt("id", new Integer(2));  
			mapMessage.setString("name", "Tom");  
			mapMessage.setInt("age", new Integer(15));  
			mapMessage.setString("address", "shanghai");  
			producer.send(mapMessage);
			
			System.out.println("Message send Success!");
			
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
