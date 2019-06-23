package d1jms;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/* 使用ActiveMQ的JMS：消息接收程序。传统JMS代码，未使用Spring组件。
 * 依赖组件：activemq-all-5.3.2.jar; 
 * ActiveMQ 5.15.9分发服务：activemq start  
 * Web访问 http://localhost:8161/  查看队列信息
 */
public class recvApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionFactory cfac = null;
		Connection conn = null;   //消息的连接
		Session sess = null; //会话

		try {
			cfac = new ActiveMQConnectionFactory("tcp://localhost:61616");
			conn  = cfac.createConnection(); //创建连接
			sess  = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//选择队列
			Destination dest = new ActiveMQQueue("myQueue"); //
			//设置消息
			MessageConsumer consumer = sess.createConsumer(dest);
			conn.start();
			
			Message msg = consumer.receive();
			TextMessage txt = (TextMessage)msg;
			
			System.out.println("Get Message: " + txt.getText() );
			
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
