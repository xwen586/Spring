package sia2.Hello;

/*
 * ����ע��ļ�����
 */
public class HelloApp {

	public static void main(String[] args) {
		//����ע�룺�ʺ���
		String greeting = "Hello World!";
		//�ڶ�����ʱע��
		GreetingService greetingService = new GreetingServiceImpl(greeting);
		greetingService.sayGreeting();

		//���������޸ģ�ʵ�ֿ��Ƶķ�ת
		String greeting2 = "Buenos Dias!";
		greetingService.setGreeting(greeting2);
		greetingService.sayGreeting();
	}

}
