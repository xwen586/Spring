package sia2.beandi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//��ʾSpring��BeanFactory����������Bean
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sia2/beandi/spring-idol.xml");

		//������ͨBean��ע��Song��������ͨ��value��ref��
		Performer performer = (Performer) ctx.getBean("kenny");
		performer.perform();

		//������һ�����ߣ�ע��Song�͸���
		Performer performer2 = (Performer) ctx.getBean("kengy");
		performer2.perform();

		System.out.println("------autowire-------");
		//autowire
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext("sia2/beandi/spring-autowire.xml");
		Performer performer3 = (Performer) ctx1.getBean("kennyauto");
		performer3.perform();
	}

}
