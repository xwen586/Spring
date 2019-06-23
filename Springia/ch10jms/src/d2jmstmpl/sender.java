package d2jmstmpl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

//使用Spring的模板类,发送消息
public class sender {

	//injected
	private JmsTemplate jmsTemplate = null;
	public void setJmsTmpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	//注入目标。
	//在sndContext.xml配置中jmsTemplate中注入缺省destination时，此注入可省略。
	private Destination destination = null;
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	//发送消息
	public void sendTextMsg(final String textMsg) {
		this.jmsTemplate.send(//destination, 
			new MessageCreator() {
			public Message createMessage(Session sess) throws JMSException{
				TextMessage msg = sess.createTextMessage();
				msg.setText(textMsg);
				return (Message)msg;
			}
		});
	}
}
