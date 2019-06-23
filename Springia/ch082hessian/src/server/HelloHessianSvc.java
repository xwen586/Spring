package server;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.caucho.hessian.server.HessianServlet;

public class HelloHessianSvc implements IHello {//extends HessianServlet
	//private static final long serialVersionUID =1L;
	
	//@Override
	public String sayHello() {
		return "Hello Hessian! wellcome.";
	}
	
	public List<String> myFruit() {
		List<String> list = new ArrayList<String>();
		list.add("blueberry");
		list.add("banana");
		list.add("grape");
		return list;
	}

	public Map<String, String> myFriends() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("son","张大四");
		map.put("daughter","李小三");
		map.put("sony","王小二");
		return map;
	}

}
