package d3jmssupp;

import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.jms.core.support.JmsGatewaySupport;

//ʹ��Spring��ģ����,������Ϣ
public class receiver extends JmsGatewaySupport {

	//injected
	//private JmsTemplate jmsTemplate = null;
	//public void setJmsTmpl(JmsTemplate jmsTemplate) {
	//	this.jmsTemplate = jmsTemplate;
	//}
	
	//ע��Ŀ��
	//private Destination destination = null;
	//public void setDestination(Destination destination) {
	//	this.destination = destination;
	//}
	
	//������Ϣ
	public TextMessage recvTextMsg() {
		Message msg = (Message)this.getJmsTemplate().receive();
		return (TextMessage)msg;
	}
	
}
