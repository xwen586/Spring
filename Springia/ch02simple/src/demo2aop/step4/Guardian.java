package demo2aop.step4;

import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.AfterThrowing;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;

/* 注解方式 spring2.5和aspectj1.9 会报错。使用spring4.0
 */
//桃园守护者  
@Aspect
public class Guardian {

	@Pointcut("execution(* demo2aop.step4.Monkey.stealPeaches(..))")  
    public void foundMonkey(){}  
  
    @Before(value="foundMonkey()")  
    public void foundBefore(){  
        System.out.println("【守护者】发现猴子正在进入果园...");  
    }  
      
    @AfterReturning("foundMonkey() && args(name,..)")  
    public void foundAfter(String name){  
        System.out.println("【守护者】抓住了猴子,守护者审问出了猴子的名字叫“"+name+"”...");  
    }
    
}
