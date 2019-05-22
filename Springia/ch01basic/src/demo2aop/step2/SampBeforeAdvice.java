package demo2aop.step2;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//MethodBeforeAdvice - 方法执行前通知
public class SampBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before method of SampBeforeAdvice.");
	}

}
