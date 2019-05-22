package sia2.beandi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//演示Spring的BeanFactory，创建基础Bean
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sia2/beandi/spring-idol.xml");

		//创建普通Bean，注入Song和乐器（通过value和ref）
		Performer performer = (Performer) ctx.getBean("kenny");
		performer.perform();

		//创建另一表演者，注入Song和钢琴
		Performer performer2 = (Performer) ctx.getBean("kengy");
		performer2.perform();

		System.out.println("------autowire-------");
		//autowire
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext("sia2/beandi/spring-autowire.xml");
		Performer performer3 = (Performer) ctx1.getBean("kennyauto");
		performer3.perform();
	}

}
