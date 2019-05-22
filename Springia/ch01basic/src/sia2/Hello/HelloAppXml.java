/*
 * 1)����spring-framework-2.0.8 (�����Ҽ� - Build Path - Add External JARs...)
 * spring-2.0.8.jar, commons-logging-1.2.jar
 * 2)ͨ�� hello.xml �����ļ���ָ��ע����Ϣ
 */
package sia2.Hello;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class HelloAppXml {

	public static void main(String[] args) {
		// TODO ͨ��Spring��ܣ���ȡ������Ϣ��
	    BeanFactory factory = 
	            new XmlBeanFactory(new ClassPathResource("/sia2/Hello/hello.xml"));

        GreetingService greetingService = 
            (GreetingService) factory.getBean("greetingService");

        greetingService.sayGreeting();

	}

}
