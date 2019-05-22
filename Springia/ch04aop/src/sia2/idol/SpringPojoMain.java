package sia2.idol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 纯POJO切面
 * 通过<aop:aspect> 将POJO对象（audience）转换为切面
 * 框架版本：spring2.0.8; aspectj1.9; commons-logging-1.2.jar 
 */
public class SpringPojoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sia2/idol/spring-pojo.xml");

		//
		Performer performer = (Performer) ctx.getBean("dukePojo");
		performer.perform();
	}

}
