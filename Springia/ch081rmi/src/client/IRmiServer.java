package client;

//接口名字其实不需要和server端一样
public interface IRmiServer {
	String getMsg(String params) throws Exception;
}
