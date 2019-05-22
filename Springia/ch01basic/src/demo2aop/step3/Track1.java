package demo2aop.step3;

import java.lang.reflect.Method;

//import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

/*
 * 改造为切面
 * 实现接口：AfterReturningAdvice - 方法执行后通知
 * MethodBeforeAdvice - 方法执行前通知
 * ThrowsAdvice - 异常日志处理类, 在抛出异常时被回调。
 */
public class Track1 implements MethodBeforeAdvice, AfterReturningAdvice, 
    ThrowsAdvice{
	
	@Override
    public void before(Method method, Object[] args, Object target)
    		throws Throwable {
		
    	String className = target.getClass().getName();        
        String methodName = method.getName();         
        String info = "前置通知：" + className + "类的" + methodName + "()方法执行";
        
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
    //当抛出IO类型的异常时的回调方法，统计异常被调用的次数
    //public void afterThrowing(IOException ex) throws Throwable {
    //	System.out.println(IOException.class.getName());
    //}
    
}
