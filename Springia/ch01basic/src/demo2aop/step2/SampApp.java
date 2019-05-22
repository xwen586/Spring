package demo2aop.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//基于代理(proxy)的AOP，针对Bean的方法做切入，要求目标Bean是一个接口实现。
//用方法执行前通知的例子
public class SampApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
	  	          "demo2aop/step2/SampApp.xml");
	    
	    //必须用接口方式做切面代理配置。
	    iHello he = (iHello)ctx.getBean("proxyService");
	    he.sayHello();
	}

}
