package sia2.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//演示Spring的BeanFactory，创建基础Bean
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("sia2/bean/spring-idol.xml");

		//创建普通Bean
		Performer performer = (Performer) ctx.getBean("duke");
		performer.perform();

		//创建有引用的Bean，并注入Sonnet29诗歌
		Performer performer2 = (Performer) ctx.getBean("duka");
		performer2.perform();

	}

}
