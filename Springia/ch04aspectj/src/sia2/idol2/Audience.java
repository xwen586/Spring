package sia2.idol2;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//���ڣ���Audienceע��Ϊһ�����档�Զ�����@AspectJ
@Aspect
public class Audience {
	public Audience() {	}

	//����һ���������е㣬�������е�ɹ���
	@Pointcut("execution(* *.perform(..))")
	public void performance() {
    }
	
	//����,ǰ��֪ͨ
	//@Before("execution(** com.spring.aop.service.perform(..))")
	@Before("performance()")
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	//�ر��ֻ�,ǰ��֪ͨ,ʹ���ڷ���performance()��ע��������
	@Before("performance()")
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	//����,����֪ͨ,ʹ���ڷ���performance()��ע��������
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	//Ҫ����Ʊ���쳣ʱ����
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Boo! We want our money back!");
	}
	
}
