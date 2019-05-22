package demo1di.step2;

/* 在Step2 中与Task与特定类型绑定(javaCoder)
 */
public class mainApp {

	public static void main(String[] args) {
		//task与javaCoder 代码紧密依赖。Task 类 和 程序员 zhang3 绑定在一起
		task t = new task("Task #2");
		javaCoder coder = new javaCoder("Lee4");
        t.setOwner(coder);  //依赖对象注入
        
        t.start();
	}

}
