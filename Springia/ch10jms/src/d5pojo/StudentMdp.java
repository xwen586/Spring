package d5pojo;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/* 基于消息驱动POJO（MDP）作为JMS消息的接收器
 * 对应于：sendApp()消息发送
 */
public class StudentMdp implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("MessageListener onMessage ...");
		if (message instanceof MapMessage) {  
			processMessage(message);
        }else {
        	System.out.println("Message is not mapMessage.");
        }
	}
	
	public void processMessage(Message message) {
		MapMessage mapm = (MapMessage)message;
		
		try {
			Student stu = new Student();
			stu.setId(mapm.getInt("id"));
			stu.setName(mapm.getString("name"));
			stu.setAge(mapm.getInt("age"));
			stu.setAddress(mapm.getString("address"));
            System.out.println(stu.toString());  
        }  
        catch (JMSException ex) {  
            throw new RuntimeException(ex);  
        }
	}
	
}
