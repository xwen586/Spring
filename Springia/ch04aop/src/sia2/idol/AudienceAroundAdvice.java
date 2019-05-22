package sia2.idol;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//��Χ֪ͨ���൱��ǰ֪ͨ�����غ�֪ͨ���׳���֪ͨ�Ľ�ϣ���AudienceAdvice������ͬ
public class AudienceAroundAdvice implements MethodInterceptor {
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		try {
			//�������ʲô����ʱ����
			audience.takeSeats();
			audience.turnOffCellPhones();

			//����Ŀ�귽��
			Object returnValue = invocation.proceed();
			//����ֵ�������޸ģ���AfterReturningAdvice��ʽֻ�ܼ�飬�����޸ġ�

			audience.applaud();
			
			return returnValue;
			
		} catch (PerformanceException throwable) {
			//Ҫ����Ʊ
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
