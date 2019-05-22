package sia2.beanset;

import java.util.Iterator;
import java.util.Properties;

//一个人的乐队，重点在对Bean的集合类装配，使用属性类
public class OneManBand3 implements Performer {
	public OneManBand3() {
	}

	public void perform() { // throws PerformanceException {
		for (Iterator iter = instruments.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			System.out.println(key + " : " + instruments.getProperty(key));
		}
	}

	// 定义集合属性，通过xml注入装配
	private Properties instruments;

	public void setInstruments(Properties instruments) {
		this.instruments = instruments;
	}
}
