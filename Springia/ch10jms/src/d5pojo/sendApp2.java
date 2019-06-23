package d5pojo;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/* 使用ActiveMQ的JMS：消息发送程序。传统JMS代码，未使用Spring组件。
 * 依赖组件：activemq-all-5.3.2.jar; 
 * ActiveMQ 5.15.9分发服务：activemq start  
 * Web访问 http://localhost:8161/  查看队列信息
 */
public class sendApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory connf = null;
		Connection conn = null;   //消息的连接
		Session sess = null; //会话

		try {
			connf = new ActiveMQConnectionFactory("tcp://localhost:61616");
			conn  = connf.createConnection(); //创建连接
			sess  = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//创建队列
			Destination dest = new ActiveMQQueue("purePojo"); //
			//设置消息
			MessageProducer producer = sess.createProducer(dest);
			//TextMessage msg = sess.createTextMessage();
			//msg.setText("Hello JMS World! with MDP.");
			//键值对消息  
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
	    	//清除资源
	        try {
	            if(sess != null) sess.close();
	            if(conn != null) conn.close();
	        }
	        catch (JMSException ex) {ex.printStackTrace();}
		}
	}

}
