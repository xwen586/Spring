/*
 * 1)引用spring-framework-2.0.8 (工程右键 - Build Path - Add External JARs...)
 * spring-2.0.8.jar, commons-logging-1.2.jar
 * 2)通过 hello.xml 配置文件，指定注入信息
 */
package sia2.Hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class HelloAppXml {

	public static void main(String[] args) {
		// TODO 通过Spring框架，获取配置信息。
	    BeanFactory factory = 
	            new XmlBeanFactory(new ClassPathResource("/sia2/Hello/hello.xml"));

        GreetingService greetingService = 
            (GreetingService) factory.getBean("greetingService");

        greetingService.sayGreeting();

	}

}
