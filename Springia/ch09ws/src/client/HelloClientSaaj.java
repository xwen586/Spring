package client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

/* 使用saaj实现，客户端引用jdk的库
 * 服务器端：spring-2.5.6.jar; spring-ws-1.5.10-all.jar
 * https://blog.csdn.net/pyzheng/article/details/84599951 * 
 */
public class HelloClientSaaj {

	public static void main(String[] args) throws 
	  UnsupportedOperationException, MalformedURLException, SOAPException {
		//在wsdl已经规定好了访问地址
        String url = "http://localhost:8080/ch09ws/hello";
        HelloClientSaaj helloClient = new HelloClientSaaj(url);
        helloClient.callWebService();

	}

	
	public static final String NAMESPACE_URI = "http://www.example.org/hello/";
    public static final String PREFIX = "tns";
    private SOAPConnectionFactory connectionFactory;
    private MessageFactory messageFactory;
    private URL url;

    public HelloClientSaaj(String url) throws UnsupportedOperationException,
            SOAPException, MalformedURLException{
        connectionFactory = SOAPConnectionFactory.newInstance();
        messageFactory = MessageFactory.newInstance();
        this.url = new URL(url);
    }
    
    /**
     *创建要远程调用的负载
     */
    private SOAPMessage createHelloRequest() throws SOAPException{
        SOAPMessage message = messageFactory.createMessage();
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name helloRequestName = envelope.createName("serviceRequest",PREFIX,NAMESPACE_URI);
        SOAPBodyElement helloRequestElement = message.getSOAPBody().addBodyElement(helloRequestName);
        helloRequestElement.setValue("提交到服务器信息");
        return message;
    }

    public void callWebService() throws SOAPException{
        SOAPMessage request = createHelloRequest();
        SOAPConnection connection = connectionFactory.createConnection();
        //开始调用，并得到返回信息
        SOAPMessage response = connection.call(request, url);
        if(!response.getSOAPBody().hasFault()){
            //处理返回信息
            writeHelloResponse(response);
        }else{
            SOAPFault fault = response.getSOAPBody().getFault();
            System.err.println("Received SOAP Fault");
            System.err.println("SOAP Fault Code : " + fault.getFaultCode());
            System.err.println("SOAP Fault String : " + fault.getFaultString());
        }
    }

    private void writeHelloResponse(SOAPMessage message) throws SOAPException{
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        Name helloResponseName = envelope.createName("serviceResponse",PREFIX,NAMESPACE_URI);
        Iterator childElements = message.getSOAPBody().getChildElements(helloResponseName);
        SOAPBodyElement helloResponseElement = (SOAPBodyElement)childElements.next();
        String value = helloResponseElement.getTextContent();
        System.out.println("调用Spring-WS返回信息: [" + value + "]");
    }
    
}
