package demo2aop.step2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//���ڴ���(proxy)��AOP�����Bean�ķ��������룬Ҫ��Ŀ��Bean��һ���ӿ�ʵ�֡�
//�÷���ִ��ǰ֪ͨ������
public class SampApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
	  	          "demo2aop/step2/SampApp.xml");
	    
	    //�����ýӿڷ�ʽ������������á�
	    iHello he = (iHello)ctx.getBean("proxyService");
	    he.sayHello();
	}

}
