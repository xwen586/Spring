package sia2.Hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class HelloAppXml {

	public static void main(String[] args) {
/*		//����ע�룺�ʺ���
		String greeting = "Hello World!";
		//�ڶ�����ʱע��
		GreetingService greetingService = new GreetingServiceImpl(greeting);
		greetingService.sayGreeting();

		//���������޸ģ�ʵ�ֿ��Ƶķ�ת
		String greeting2 = "Buenos Dias!";
		greetingService.setGreeting(greeting2);
		greetingService.sayGreeting();
*/
	    BeanFactory factory = 
	            new XmlBeanFactory(new ClassPathResource("sia2/Hello/hello.xml"));

	        GreetingService greetingService = 
	            (GreetingService) factory.getBean("greetingService");

	        greetingService.sayGreeting();
	}

}
