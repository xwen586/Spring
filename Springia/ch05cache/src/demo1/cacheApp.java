package demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class cacheApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo1/appContext.xml");
		
		myService mySvc = (myService) ctx.getBean("mySvc");
		mySvc.query(10);
		mySvc.query(20);
		//±»Cache
		for(int i=0; i<10; i++) mySvc.query(10);
		mySvc.query(30);
	}

}
