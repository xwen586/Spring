package d4mdp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/* ������Ϣ����POJO��MDP����ΪJMS��Ϣ�Ľ�����
 * https://bijian1013.iteye.com/blog/2309678
 * https://bijian1013.iteye.com/category/331337
 * http://www.shouce.ren/api/spring2.5/ch19s02.html
 */
public class SimpMdpListener implements MessageListener {

	public void onMessage(Message message) {
		System.out.println("MessageListener onMessage ...");
		if (message instanceof TextMessage) {  
			processMessage(message);
        }
		
	}
	
	public void processMessage(Message message) {
		try {  
            System.out.println(((TextMessage) message).getText());  
        }  
        catch (JMSException ex) {  
            throw new RuntimeException(ex);  
        }
	}
	
}
