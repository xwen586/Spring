package client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class rmiCliApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client/appContext.xml");

		IRmiServer helloWord = (IRmiServer) ctx.getBean("hello");
		IRmiServer printDate = (IRmiServer) ctx.getBean("printDate");
		
		try {
			String msg = helloWord.getMsg("");
			System.out.println(msg);
			
			msg = printDate.getMsg("My RMI Calling...");
			System.out.println(msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
