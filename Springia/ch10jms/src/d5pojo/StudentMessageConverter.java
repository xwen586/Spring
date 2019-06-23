package d5pojo;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

/* *
 * 对象与消息转换，注入到适配器中，完成消息发送/接收时的转换。
 * 使得POJO更单纯
 */
public class StudentMessageConverter implements MessageConverter {

	public StudentMessageConverter() {}

	   public Object fromMessage(Message message) throws JMSException,
	                     MessageConversionException {

	      if (!(message instanceof MapMessage)) {
	         throw new MessageConversionException("Message isn't a MapMessage");
	      }
	      System.out.println("StudentMessageConverter fromMessage ...\n"
	          + message.toString() );

	      MapMessage mapm = (MapMessage) message;
	      Student student = new Student();

	      student.setId(mapm.getInt("id"));
	      student.setName(mapm.getString("name"));
	      student.setAge(mapm.getInt("age"));
	      student.setAddress(mapm.getString("address"));

	      return student;
	   }

	   public Message toMessage(Object object, Session session)
	                     throws JMSException, MessageConversionException {

	      if (!(object instanceof Student)) {
	         throw new MessageConversionException("Object isn't a Student");
	      }

	      Student student = (Student) object;
	      MapMessage message = session.createMapMessage();
	      message.setInt("id", student.getId());
	      message.setString("name", student.getName());
	      message.setInt("age", student.getAge());
	      message.setString("address", student.getAddress());

	      return message;
	   }
	   
}
