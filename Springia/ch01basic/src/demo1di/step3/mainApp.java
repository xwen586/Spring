package demo1di.step3;

/* 在Step3 中与Task与特定接口绑定(coder)
 * https://www.jianshu.com/p/506dcd94d4f9
 */
public class mainApp {

	public static void main(String[] args) {
		//task与javaCoder 代码紧密依赖。Task 类 和 程序员 zhang3 绑定在一起
		task t = new task("Task #3");
		coder coder = new javaCoder("Lee4");
		coder coder2 = new cppCoder("Wang5");
		
        t.setOwner(coder);  //依赖对象注入，装配对象，由主动生成对象变为被动指定对象，就是控制反转(IoC)
        t.start();
        
        t.setOwner(coder2);  //依赖对象注入        
        t.start();

	}

}
