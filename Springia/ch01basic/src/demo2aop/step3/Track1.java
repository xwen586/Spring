package demo2aop.step3;

import java.lang.reflect.Method;

//import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/*
 * ����Ϊ����
 * ʵ�ֽӿڣ�AfterReturningAdvice - ����ִ�к�֪ͨ
 * MethodBeforeAdvice - ����ִ��ǰ֪ͨ
 * ThrowsAdvice - �쳣��־������, ���׳��쳣ʱ���ص���
 */
public class Track1 implements MethodBeforeAdvice, AfterReturningAdvice, 
    ThrowsAdvice{
	
	@Override
    public void before(Method method, Object[] args, Object target)
    		throws Throwable {
		
    	String className = target.getClass().getName();        
        String methodName = method.getName();         
        String info = "ǰ��֪ͨ��" + className + "���" + methodName + "()����ִ��";
        
    	System.out.println("----before: " + info);
    }
    
	@Override
    public void afterReturning(Object rtn, Method method, 
    	      Object[] args, Object target) throws Throwable {
    	System.out.println("----afterReturning: ");
    }
    
    public void afterThrowing(Throwable throwable) {
    	System.out.println("----afterThrowing: ");
    }
    //���׳�IO���͵��쳣ʱ�Ļص�������ͳ���쳣�����õĴ���
    //public void afterThrowing(IOException ex) throws Throwable {
    //	System.out.println(IOException.class.getName());
    //}
    
}
