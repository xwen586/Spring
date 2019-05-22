package sia2.idol;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//周围通知：相当于前通知、返回后通知、抛出后通知的结合；与AudienceAdvice功能相同
public class AudienceAroundAdvice implements MethodInterceptor {
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try {
			//切面的做什么、何时做。
			audience.takeSeats();
			audience.turnOffCellPhones();

			//调用目标方法
			Object returnValue = invocation.proceed();
			//返回值可以做修改，对AfterReturningAdvice方式只能检查，不能修改。

			audience.applaud();
			
			return returnValue;
			
		} catch (PerformanceException throwable) {
			//要求退票
			audience.demandRefund();
			throw throwable;
		}

	}

	// injected
	private Audience audience;

	public void setAudience(Audience audience) {
		this.audience = audience;
	}
}
