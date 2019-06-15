package server;

import org.springframework.util.Assert;
import org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* ��һ��EndPoint��������յ���xml������xml.��Ȼ, Spring Web Service�ṩ�˺ܶ�����ʵ��,
 * ����Dom4j, JDom�ȵ�.��������ʹ��JDK�Դ���,
 * ��Ҫ�̳�org.springframework.ws.server.endpoint.AbstractDomPayloadEndpoint.
 * https://blog.csdn.net/pyzheng/article/details/84599951 
 */
public class HelloEndPoint extends AbstractDomPayloadEndpoint {
	//�������Ӧ�������ռ�
    public static final String NAMESPACE_URI = "http://www.example.org/hello/";

    //Ԥ��Ҫ��ı�������
    public static final String HELLO_REQUEST_LOCAL_NAME = "serviceRequest";

    // ������Ӧ�ı�������
    public static final String HELLO_RESPONSE_LOCAL_NAME = "serviceResponse";

    private IHello helloService;

    @Override
    protected Element invokeInternal(Element requestElement, Document document)throws Exception {
        //����֤����������Ϣ�Ƿ���ȷ
        Assert.isTrue(NAMESPACE_URI.equals(requestElement.getNamespaceURI()), "Invalid namespace");
        Assert.isTrue(HELLO_REQUEST_LOCAL_NAME.equals(requestElement.getLocalName()), "Invalid local name");

        //��ô����������Ϣ
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

        //��Ϣ����
        String response = helloService.sayHello(requestText.getNodeValue());

        //��Ӧ���ͻ���
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
