package sia2.idol2;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* @AspectJ注解驱动的切面, 自动代理Bean, 使用AspectJ。
 * 通过对Audience类做注解，实现切面定义；xml配置实现被监控类的切入。
 * 框架版本：spring4.3.9; aspectj1.9; commons-logging-1.2.jar
 */
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sia2/idol2/spring-idol.xml");

		//
		Performer performer = (Performer) ctx.getBean("dukeTarget");
		performer.perform();
		
	}

}
