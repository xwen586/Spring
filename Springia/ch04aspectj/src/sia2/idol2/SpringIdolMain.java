package sia2.idol2;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* @AspectJע������������, �Զ�����Bean, ʹ��AspectJ��
 * ͨ����Audience����ע�⣬ʵ�����涨�壻xml����ʵ�ֱ����������롣
 * ��ܰ汾��spring4.3.9; aspectj1.9; commons-logging-1.2.jar
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
