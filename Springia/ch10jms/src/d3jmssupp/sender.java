package d3jmssupp;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

//使用Spring的模板类,发送消息
public class sender extends JmsGatewaySupport {

	//injected
	//private JmsTemplate jmsTemplate = null;
	//public void setJmsTmpl(JmsTemplate jmsTemplate) {
	//	this.jmsTemplate = jmsTemplate;
	//}
	
	//注入目标
	//private Destination destination = null;
	//public void setDestination(Destination destination) {
	//	this.destination = destination;
	//}
	
	//发送消息
	public void sendTextMsg(final String textMsg) {
		this.getJmsTemplate().send(	new MessageCreator() {
			public Message createMessage(Session sess) throws JMSException{
				TextMessage msg = sess.createTextMessage();
				msg.setText(textMsg);
				return (Message)msg;
			}
		});
	}
}
