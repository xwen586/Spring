package sia2.idol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 基于代理的经典AOP。通过继承接口演示AOP
 * （MethodBeforeAdvice前置通知, AfterReturningAdvice后置通知, 
 *  MethodInterceptor 环绕通知，还有点bug）
 * 框架版本：spring2.0.8; commons-logging-1.2.jar 
 */
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sia2/idol/spring-idol.xml");

		//
		Performer performer = (Performer) ctx.getBean("proxyDuke");
		performer.perform();
		
		System.out.println("--------批量代理方法--------");
		//批量代理方法
		Performer pDuke = (Performer) ctx.getBean("pDuke");
		Performer pStevie = (Performer) ctx.getBean("pStevie");
		pDuke.perform();
		pStevie.perform();
	}

}
