package demo1di.step2;

/* ��Step2 ����Task���ض����Ͱ�(javaCoder)
 */
public class mainApp {

	public static void main(String[] args) {
		//task��javaCoder �������������Task �� �� ����Ա zhang3 ����һ��
		task t = new task("Task #2");
		javaCoder coder = new javaCoder("Lee4");
        t.setOwner(coder);  //��������ע��
        
        t.start();
	}

}
