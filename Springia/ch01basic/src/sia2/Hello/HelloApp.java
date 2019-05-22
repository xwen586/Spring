package sia2.Hello;

/*
 * 依赖注入的简单例子
 */
public class HelloApp {

	public static void main(String[] args) {
		//依赖注入：问候语
		String greeting = "Hello World!";
		//在对象构造时注入
		GreetingService greetingService = new GreetingServiceImpl(greeting);
		greetingService.sayGreeting();

		//依赖对象修改，实现控制的翻转
		String greeting2 = "Buenos Dias!";
		greetingService.setGreeting(greeting2);
		greetingService.sayGreeting();
	}

}
