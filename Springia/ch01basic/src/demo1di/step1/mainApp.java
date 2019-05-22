package demo1di.step1;

/* 在Step1 中与Task与特定实例绑定(zhang3 javaCoder)
 * https://github.com/xwen586/Spring.git
 */
public class mainApp {

	public static void main(String[] args) {
		//task与javaCoder 代码紧密依赖。Task 类 和 程序员 zhang3 绑定在一起
		task t = new task("Task #1");
        t.start();
	}

}
