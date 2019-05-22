package demo2aop.step4;

import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.AfterThrowing;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;


//��԰�ػ���  https://www.cnblogs.com/duanxz/p/5194801.html
@Aspect
public class Guardian {

	@Pointcut("execution(* demo2aop.step4.Monkey.stealPeaches(..))")  
    public void foundMonkey(){}  
  
    @Before(value="foundMonkey()")  
    public void foundBefore(){  
        System.out.println("���ػ��ߡ����ֺ������ڽ����԰...");  
    }  
      
    @AfterReturning("foundMonkey() && args(name,..)")  
    public void foundAfter(String name){  
        System.out.println("���ػ��ߡ�ץס�˺���,�ػ������ʳ��˺��ӵ����ֽС�"+name+"��...");  
    }
    
}
