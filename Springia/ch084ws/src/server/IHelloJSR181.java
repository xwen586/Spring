package server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/*
 * ͨ��ע�ⷽʽ����
 * https://blog.csdn.net/yimeng528/article/details/84509076
 */
@WebService
public interface IHelloJSR181 {
	@WebMethod//(operationName="sayHello")
	String sayHello(String username); //@WebParam(name = "username") 
}
