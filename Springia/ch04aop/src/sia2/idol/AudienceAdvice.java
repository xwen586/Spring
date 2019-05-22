package sia2.idol;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

//观众通知，即切面通知。定义了观众功能如何被通知
public class AudienceAdvice implements MethodBeforeAdvice,
    AfterReturningAdvice, ThrowsAdvice {

  public AudienceAdvice() {}
    
  //前通知
  public void before(Method method, Object[] args, Object target) 
      throws Throwable {
    audience.takeSeats();
    audience.turnOffCellPhones();
  }
  
  //返回后通知，实现自AfterReturningAdvice接口
  public void afterReturning(Object rtn, Method method, 
      Object[] args, Object target) throws Throwable {
    audience.applaud();
  }
  
  //抛出后通知，实现自ThrowsAdvice接口
  public void afterThrowing(Throwable throwable) {
    audience.demandRefund(); //要求退款
  }
  
  public void afterThrowing(Method method, Object[] args, Object target, 
      Throwable throwable) {
    audience.demandRefund();
  }
  
  // injected
  private Audience audience;
  public void setAudience(Audience audience) {
    this.audience = audience;
  }
}