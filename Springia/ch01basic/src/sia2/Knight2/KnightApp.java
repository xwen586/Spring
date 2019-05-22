package sia2.Knight2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 1)引用spring-framework-2.0.8 (工程右键 - Build Path - Add External JARs...)
 * spring-2.0.8.jar, commons-logging-1.2.jar
 * 2)通过 Knight.xml 配置文件，指定注入信息
 */
public class KnightApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    //KnightOfTheRoundTable knight  = new KnightOfTheRoundTable("Bedivere");	    
	    //骑士knight 与寻找圣杯 捆绑在一起，骑士应还有其他任务
	    //HolyGrail grail = knight.embarkOnQuest();
	    //grail.isHoly();
	    
		/* 通过knight.xml，向KnightOfRoundTable注入了一个quest（HolyGrailQuest）
		 * 不再用代码方式来指定注入关系。
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
