package d2jmstmpl;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

//使用Spring的模板类,接收消息
public class receiver {

	//injected
	private JmsTemplate jmsTemplate = null;
	public void setJmsTmpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	//注入目标
	private Destination destination = null;
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	//接收消息
	public TextMessage recvTextMsg() {
		Message msg = this.jmsTemplate.receive(destination);
		return (TextMessage)msg;
	}
	
}
