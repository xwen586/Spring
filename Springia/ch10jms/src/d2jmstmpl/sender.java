package d2jmstmpl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

//ʹ��Spring��ģ����,������Ϣ
public class sender {

	//injected
	private JmsTemplate jmsTemplate = null;
	public void setJmsTmpl(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	//ע��Ŀ�ꡣ
	//��sndContext.xml������jmsTemplate��ע��ȱʡdestinationʱ����ע���ʡ�ԡ�
	private Destination destination = null;
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	//������Ϣ
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
