package demo1di.step3;

/* ��Step3 ����Task���ض��ӿڰ�(coder)
 * https://www.jianshu.com/p/506dcd94d4f9
 */
public class mainApp {

	public static void main(String[] args) {
		//task��javaCoder �������������Task �� �� ����Ա zhang3 ����һ��
		task t = new task("Task #3");
		coder coder = new javaCoder("Lee4");
		coder coder2 = new cppCoder("Wang5");
		
        t.setOwner(coder);  //��������ע�룬װ��������������ɶ����Ϊ����ָ�����󣬾��ǿ��Ʒ�ת(IoC)
        t.start();
        
        t.setOwner(coder2);  //��������ע��        
        t.start();

	}

}
