package sia2.idol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* ���ڴ���ľ���AOP��ͨ���̳нӿ���ʾAOP
 * ��MethodBeforeAdviceǰ��֪ͨ, AfterReturningAdvice����֪ͨ, 
 *  MethodInterceptor ����֪ͨ�����е�bug��
 * ��ܰ汾��spring2.0.8; commons-logging-1.2.jar 
 */
public class SpringIdolMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"sia2/idol/spring-idol.xml");

		//
		Performer performer = (Performer) ctx.getBean("proxyDuke");
		performer.perform();
		
		System.out.println("--------����������--------");
		//����������
		Performer pDuke = (Performer) ctx.getBean("pDuke");
		Performer pStevie = (Performer) ctx.getBean("pStevie");
		pDuke.perform();
		pStevie.perform();
	}

}
