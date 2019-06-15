package server;

public class HelloServiceImpl implements IHello {

	@Override
	public String sayHello(String name) {
		return "Hello, " + name + "Wellcome!";
	}

}
