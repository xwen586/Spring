package client;

import java.util.List;
import java.util.Map;

import org.codehaus.xfire.XFireFactory;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* �ͻ��˵��� WebService,��һ�ֿ������ԺͿ����ϵͳƽ̨��Զ�̵��ü�����
 * �������ˣ�spring-2.5.6.jar; xfire-all-1.2.6.jar
 * �����������jdom-1.1.3.jar(jdom-2.0.6.jar�汾̫��); wsdl4j-1.6.3.jar
 * �ͻ���������XmlSchema-1.4.7.jar; commons-httpclient-3.1.jar(httpclient-4.1.3.jar�Ľṹ�����仯);
 *  commons-codec-1.12.jar
 */
public class HelloApp {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʹ��Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client/appCliContext.xml");
		IHelloClient helloWord = (IHelloClient) ctx.getBean("hello");
		
		try {
			String msg = helloWord.sayHello("A1");
			System.out.println(msg);
			
			//List<String> list = helloWord.myFruit();
			//System.out.println(list.toString());
			
			//Map<String, String> map = helloWord.myFriends();
			//System.out.println(map.toString());


			//ʹ��xfire��client���
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
