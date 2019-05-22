package sia2.Knight2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 1)����spring-framework-2.0.8 (�����Ҽ� - Build Path - Add External JARs...)
 * spring-2.0.8.jar, commons-logging-1.2.jar
 * 2)ͨ�� Knight.xml �����ļ���ָ��ע����Ϣ
 */
public class KnightApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //KnightOfTheRoundTable knight  = new KnightOfTheRoundTable("Bedivere");	    
	    //��ʿknight ��Ѱ��ʥ�� ������һ����ʿӦ������������
	    //HolyGrail grail = knight.embarkOnQuest();
	    //grail.isHoly();
	    
		/* ͨ��knight.xml����KnightOfRoundTableע����һ��quest��HolyGrailQuest��
		 * �����ô��뷽ʽ��ָ��ע���ϵ��
		 */
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
	    	          "sia2/Knight2/knight.xml");

	    Knight knight = (Knight) ctx.getBean("knight");
	    //BeanFactory factory = new XmlBeanFactory(new FileSystemResource("knight.xml"));
	    //Knight knight = (Knight)factory.getBean("knight");

	    try {
	    	
	    	HolyGrail grail = (HolyGrail) knight.embarkOnQuest();
	    	grail.isHoly();
	    	
		} catch (QuestFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
