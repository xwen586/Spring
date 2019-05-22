package demo2aop.step4;

import org.aspectj.lang.annotation.AfterReturning;  
import org.aspectj.lang.annotation.AfterThrowing;  
import org.aspectj.lang.annotation.Around;  
import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.aspectj.lang.annotation.Pointcut;


//桃园守护者  https://www.cnblogs.com/duanxz/p/5194801.html
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
