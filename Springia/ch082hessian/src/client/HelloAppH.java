package client;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.caucho.hessian.client.HessianProxyFactory;

/* �ͻ��˵��� Hessian��ʹ�ö�������Server����������HTTPЭ��
 * �������ˣ�spring-2.5.6.jar; hessian-3.1.5.jar(��spring4������)
 * �ͻ�����hessian-3.1.5 ���÷���� hessian-4.0.38����expected hessian reply at 0x48 (H)
 */
public class HelloAppH {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ʹ��Spring����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client/appCliContext.xml");
		IHelloClient helloWord = (IHelloClient) ctx.getBean("helloH");

		//
		String url = "http://127.0.0.1:8080/ch082hessian/helloHess";
		
		try {
			String msg = helloWord.sayHello();
			System.out.println(msg);
			
			List<String> list = helloWord.myFruit();
			System.out.println(list.toString());
			
			Map<String, String> map = helloWord.myFriends();
			System.out.println(map.toString());

			IHelloClient service = (IHelloClient) (new HessianProxyFactory()).create(IHelloClient.class, url);
			String msg2 = service.sayHello();
			System.out.println("msg2: " + msg2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
