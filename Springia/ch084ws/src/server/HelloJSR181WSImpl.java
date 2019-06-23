package server;

import javax.jws.WebService;

@WebService(serviceName = "helloJsr181ws", endpointInterface = "server.IHelloJSR181")
public class HelloJSR181WSImpl implements IHelloJSR181 {

	@Override
	public String sayHello(String username) {//
		// TODO Auto-generated method stub
		return "Hello JSR181 WebService! wellcome " + username;
	}

}
