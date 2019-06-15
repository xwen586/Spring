package server;

import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* 现一个EndPoint来处理接收到的xml及返回xml.当然, Spring Web Service提供了很多抽象的实现,
 * 包括Dom4j, JDom等等.这里我们使用JDK自带的,
 * 需要继承org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint.
 * https://blog.csdn.net/pyzheng/article/details/84599951 
 */
public class HelloEndPoint extends AbstractDomPayloadEndpoint {
	//请求和响应的命名空间
    public static final String NAMESPACE_URI = "http://www.example.org/hello/";

    //预期要求的本地名称
    public static final String HELLO_REQUEST_LOCAL_NAME = "serviceRequest";

    // 创建响应的本地名称
    public static final String HELLO_RESPONSE_LOCAL_NAME = "serviceResponse";

    private IHello helloService;

    @Override
    protected Element invokeInternal(Element requestElement, Document document)throws Exception {
        //先验证传进来的信息是否正确
        Assert.isTrue(NAMESPACE_URI.equals(requestElement.getNamespaceURI()), "Invalid namespace");
        Assert.isTrue(HELLO_REQUEST_LOCAL_NAME.equals(requestElement.getLocalName()), "Invalid local name");

        //获得船机那里的信息
        NodeList children = requestElement.getChildNodes();
        Text requestText = null;
        for(int i=0; i<children.getLength(); i++){
            if(children.item(i).getNodeType() == Node.TEXT_NODE){
                requestText = (Text) children.item(i);
            }
        }

        if(requestText == null){
            throw new IllegalArgumentException("Could not find request text node");
        }

        //信息处理
        String response = helloService.sayHello(requestText.getNodeValue());

        //响应给客户端
        Element responseElement = document.createElementNS(NAMESPACE_URI, HELLO_RESPONSE_LOCAL_NAME);
        Text responseText = document.createTextNode(response);
        responseElement.appendChild(responseText);
        return responseElement;
    }
    
    public IHello getHelloService() {
        return helloService;
    }
    
    public void setHelloService(IHello helloService) {
        this.helloService = helloService;
    }

}
