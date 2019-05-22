package demo2aop.step4;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* https://www.cnblogs.com/duanxz/p/5194801.html
 * ���������õ���aspectj-1.9.3.jar; jdk1.8; spring2.5
 * �ᱨ�� java.lang.IllegalStateException: AnnotationAwareAspectJAutoProxyCreator is only available on Java 1.5 and higher
 * ����ʹ�� spring4
 * https://blog.csdn.net/qq_20499001/article/details/80143956
 * */
public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"demo2aop/step4/config.xml");  
        Monkey monkey = (Monkey) context.getBean("monkey");
        
        try {
            monkey.stealPeaches("���ʥ�Ĵ�ͽ��");  
        }  
        catch(Exception e) {}  

	}

}
