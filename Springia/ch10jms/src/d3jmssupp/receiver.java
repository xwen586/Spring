package d3jmssupp;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.support.JmsGatewaySupport;

//使用Spring的模板类,接收消息
public class receiver extends JmsGatewaySupport {

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
	
	//接收消息
	public TextMessage recvTextMsg() {
		Message msg = (Message)this.getJmsTemplate().receive();
		return (TextMessage)msg;
	}
	
}
