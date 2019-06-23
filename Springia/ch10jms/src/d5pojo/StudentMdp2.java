package d5pojo;

import java.util.Map;

/* ������Ϣ����POJO��MDP����ΪJMS��Ϣ�Ľ�����
 * ����Ҫ�̳�MessageListener, ʹ��onMessage()����
 */
public class StudentMdp2 { //implements MessageListener

	public StudentMdp2() {}
	
	//ȡ���÷���
	//public void onMessage(Message message) {}
	
	//ʹ��java.util.Map��ʹ��StudentMdp2Ϊ��POJO
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
	
	//Context��ע��ת������ʹ�������ֱ��ʹ����Ϣת�����Ķ���
	public void processStudentInfo(Student driver) {
		//�����κ�Mapת��ΪStudent�Ĵ���ֱ���ύ��ע���ת����StudentMessageConverter��
		System.out.println("StudentMdp2 processStudentInfo:" + driver.toString() );
	}
	
}
