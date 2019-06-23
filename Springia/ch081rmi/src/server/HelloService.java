package server;

public class HelloService implements IRmiService {

	@Override
	public String getMsg(String params) throws Exception {
		return "Hello World! RMI";
	}

}
