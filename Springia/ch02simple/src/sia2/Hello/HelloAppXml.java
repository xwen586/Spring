package sia2.Hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class HelloAppXml {

	public static void main(String[] args) {
/*		//依赖注入：问候语
		String greeting = "Hello World!";
		//在对象构造时注入
		GreetingService greetingService = new GreetingServiceImpl(greeting);
		greetingService.sayGreeting();

		//依赖对象修改，实现控制的翻转
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
