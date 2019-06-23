package xfire.client;

import java.util.List;
import java.util.Map;

//只定义接口，由Spring做远程调用的实现
public interface IHelloClient {
	public String sayHello();
	public List<String> myFruit();
	public Map<String, String> myFriends();
}
