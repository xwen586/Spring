package d2jmstmpl;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

//ʹ��Spring��ģ����,������Ϣ
public class receiver {

	//injected
	private JmsTemplate jmsTemplate = null;
	public void setJmsTmpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	//ע��Ŀ��
	private Destination destination = null;
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	//������Ϣ
	public TextMessage recvTextMsg() {
		Message msg = this.jmsTemplate.receive(destination);
		return (TextMessage)msg;
	}
	
}
