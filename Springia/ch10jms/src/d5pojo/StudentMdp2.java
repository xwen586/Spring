package d5pojo;

import java.util.Map;

/* 基于消息驱动POJO（MDP）作为JMS消息的接收器
 * 不需要继承MessageListener, 使用onMessage()方法
 */
public class StudentMdp2 { //implements MessageListener

	public StudentMdp2() {}
	
	//取消该方法
	//public void onMessage(Message message) {}
	
	//使用java.util.Map，使得StudentMdp2为纯POJO
	public void processStudentInfo(Map map) {
		System.out.println("StudentMdp2 processStudentInfo(Map) ... :" + map.toString() );
		try {
			Student stu = new Student();
			stu.setId(Integer.parseInt(map.get("id").toString()));
			stu.setName(map.get("name").toString());
			stu.setAge(Integer.parseInt(map.get("age").toString()));
			stu.setAddress(map.get("address").toString());
            System.out.println(stu.toString());  
        }  
        catch (Exception ex) {  
            throw new RuntimeException(ex);  
        }
	}
	
	//Context中注入转换器，使处理程序直接使用消息转换来的对象。
	public void processStudentInfo(Student driver) {
		//不做任何Map转换为Student的处理，直接提交给注入的转换器StudentMessageConverter中
		System.out.println("StudentMdp2 processStudentInfo:" + driver.toString() );
	}
	
}
