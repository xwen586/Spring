package xfire.client;

import java.util.List;
import java.util.Map;

//ֻ����ӿڣ���Spring��Զ�̵��õ�ʵ��
public interface IHelloClient {
	public String sayHello();
	public List<String> myFruit();
	public Map<String, String> myFriends();
}
