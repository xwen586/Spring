package client;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.caucho.burlap.client.BurlapProxyFactory;

/* 客户端调用Burlap，使用xml与Server交互，基于HTTP协议
 * 服务器端：spring-2.5.6.jar; hessian-3.1.5.jar(与spring4不兼容)
 */
public class HelloAppB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用Spring配置
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client/appCliContext.xml");
		IHelloClient helloWord = (IHelloClient) ctx.getBean("helloB");

		//
		String url = "http://127.0.0.1:8080/ch082hessian/helloBurlap";
		
		try {
			String msg = helloWord.sayHello();
			System.out.println(msg);
			
			List<String> list = helloWord.myFruit();
			System.out.println(list.toString());
			
			Map<String, String> map = helloWord.myFriends();
			System.out.println(map.toString());

			IHelloClient service = (IHelloClient) (new BurlapProxyFactory()).create(IHelloClient.class, url);
			String msg2 = service.sayHello();
			System.out.println("msg2: " + msg2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
