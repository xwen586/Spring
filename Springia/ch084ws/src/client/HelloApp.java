package client;

import java.util.List;
import java.util.Map;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 客户端调用 WebService,是一种跨编程语言和跨操作系统平台的远程调用技术。
 * 服务器端：spring-2.5.6.jar; xfire-all-1.2.6.jar
 * 服务端依赖：jdom-1.1.3.jar(jdom-2.0.6.jar版本太高); wsdl4j-1.6.3.jar
 * 客户端依赖：XmlSchema-1.4.7.jar; commons-httpclient-3.1.jar(httpclient-4.1.3.jar的结构发生变化);
 *  commons-codec-1.12.jar
 */
public class HelloApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用Spring配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client/appCliContext.xml");
		IHelloClient helloWord = (IHelloClient) ctx.getBean("hello");
		
		try {
			String msg = helloWord.sayHello("A1");
			System.out.println(msg);
			
			//List<String> list = helloWord.myFruit();
			//System.out.println(list.toString());
			
			//Map<String, String> map = helloWord.myFriends();
			//System.out.println(map.toString());


			//使用xfire的client组件
			Service serviceModel = new ObjectServiceFactory().create(IHelloClient.class);
			XFireProxyFactory factory = new XFireProxyFactory(XFireFactory.newInstance().getXFire());

			String url = "http://localhost:8080/ch084ws/service/helloJsr181ws";//
			IHelloClient cws = (IHelloClient)factory.create(serviceModel, url);
			String result = cws.sayHello("A2");
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
