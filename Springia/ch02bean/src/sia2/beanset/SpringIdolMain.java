package sia2.beanset;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//演示Spring的BeanFactory，创建基础Bean
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sia2/beanset/spring-idol.xml");

		//创建普通Bean，注入乐器集合，用list或set
		Performer performer = (Performer) ctx.getBean("hank");
		performer.perform();

		System.out.println("------- Map --------");
		//创建另一表演者，注入乐器集合，用Map
		Performer performer2 = (Performer) ctx.getBean("hankmap");
		performer2.perform();

		System.out.println("------- Properties --------");
		//创建另一表演者，注入乐器集合，用Map
		Performer performer3 = (Performer) ctx.getBean("hankprop");
		performer3.perform();
	}

}
