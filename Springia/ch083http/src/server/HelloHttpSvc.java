package server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelloHttpSvc implements IHello {

	@Override
	public String sayHello() {
		return "Hello Http Invoke! wellcome.";
	}

	@Override
	public List<String> myFruit() {
		List<String> list = new ArrayList<String>();
		list.add("blueberry");
		list.add("banana");
		list.add("grape");
		return list;
	}

	@Override
	public Map<String, String> myFriends() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("son","�Ŵ���");
		map.put("daughter","��С��");
		map.put("sony","��С��");
		return map;
	}

}
