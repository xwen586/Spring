package sia2.idol3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 注入式ApsectJ切面。
 * aspect JudgeAspect {}
 * 框架版本：spring2.5.6; aspectj1.9; commons-logging-1.2.jar
 */
public class SpringJudgeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sia2/idol3/spring-judge.xml");

		Performer bo = (Performer) ctx.getBean("bo");
		Performer william = (Performer) ctx.getBean("william");
		Performer carrie = (Performer) ctx.getBean("carrie");
		bo.perform();
		carrie.perform();
		william.perform();
		
	}

}
