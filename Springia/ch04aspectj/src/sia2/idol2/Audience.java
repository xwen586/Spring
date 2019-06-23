package sia2.idol2;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//观众，把Audience注解为一个切面。自动代理@AspectJ
@Aspect
public class Audience {
	public Audience() {	}

	//定义一个公共的切点，后续各切点可共用
	@Pointcut("execution(* *.perform(..))")
	public void performance() {
    }
	
	//就座,前置通知
	//@Before("execution(** com.spring.aop.service.perform(..))")
	@Before("performance()")
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	//关闭手机,前置通知,使用在方法performance()上注册的切入点
	@Before("performance()")
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	//鼓掌,后置通知,使用在方法performance()上注册的切入点
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	//要求退票，异常时调用
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Boo! We want our money back!");
	}
	
}
