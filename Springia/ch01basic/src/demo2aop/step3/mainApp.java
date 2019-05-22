package demo2aop.step3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mainApp {

	public static void main(String[] args) {
		
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
  	          "demo2aop/step3/aoptest.xml");

	    iPerson doctor = (iPerson) ctx.getBean("proxyD");
	    iPerson sports = (iPerson) ctx.getBean("proxyS");

		doctor.sayHello();
		sports.play();
		
		System.out.println("--------批量代理方法--------");
		//批量代理方法
		iPerson pDoctor = (iPerson) ctx.getBean("pDoctor");
		iPerson pSports = (iPerson) ctx.getBean("pSports");
		pDoctor.sayHello();
		pSports.play();

	}
}
