package sia2.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//��ʾSpring��BeanFactory����������Bean
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sia2/bean/spring-idol.xml");

		//������ͨBean
		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();

		//���������õ�Bean����ע��Sonnet29ʫ��
		Performer performer2 = (Performer) ctx.getBean("duka");
		performer2.perform();

	}

}
