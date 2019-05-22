package sia2.beanset;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//��ʾSpring��BeanFactory����������Bean
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sia2/beanset/spring-idol.xml");

		//������ͨBean��ע���������ϣ���list��set
		Performer performer = (Performer) ctx.getBean("hank");
		performer.perform();

		System.out.println("------- Map --------");
		//������һ�����ߣ�ע���������ϣ���Map
		Performer performer2 = (Performer) ctx.getBean("hankmap");
		performer2.perform();

		System.out.println("------- Properties --------");
		//������һ�����ߣ�ע���������ϣ���Map
		Performer performer3 = (Performer) ctx.getBean("hankprop");
		performer3.perform();
	}

}
