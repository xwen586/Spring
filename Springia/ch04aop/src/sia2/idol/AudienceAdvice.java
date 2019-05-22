package sia2.idol;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

//����֪ͨ��������֪ͨ�������˹��ڹ�����α�֪ͨ
public class AudienceAdvice implements MethodBeforeAdvice,
    AfterReturningAdvice, ThrowsAdvice {

  public AudienceAdvice() {}
    
  //ǰ֪ͨ
  public void before(Method method, Object[] args, Object target) 
      throws Throwable {
    audience.takeSeats();
    audience.turnOffCellPhones();
  }
  
  //���غ�֪ͨ��ʵ����AfterReturningAdvice�ӿ�
  public void afterReturning(Object rtn, Method method, 
      Object[] args, Object target) throws Throwable {
    audience.applaud();
  }
  
  //�׳���֪ͨ��ʵ����ThrowsAdvice�ӿ�
  public void afterThrowing(Throwable throwable) {
    audience.demandRefund(); //Ҫ���˿�
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