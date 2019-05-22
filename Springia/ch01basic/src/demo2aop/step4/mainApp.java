package demo2aop.step4;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* https://www.cnblogs.com/duanxz/p/5194801.html
 * 本程序引用的是aspectj-1.9.3.jar; jdk1.8; spring2.5
 * 会报错： java.lang.IllegalStateException: AnnotationAwareAspectJAutoProxyCreator is only available on Java 1.5 and higher
 * 建议使用 spring4
 * https://blog.csdn.net/qq_20499001/article/details/80143956
 * */
public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"demo2aop/step4/config.xml");  
        Monkey monkey = (Monkey) context.getBean("monkey");
        
        try {
            monkey.stealPeaches("孙大圣的大徒弟");  
        }  
        catch(Exception e) {}  

	}

}
