package sia2.beanset;

import java.util.Iterator;
import java.util.Properties;

//һ���˵��ֶӣ��ص��ڶ�Bean�ļ�����װ�䣬ʹ��������
public class OneManBand3 implements Performer {
	public OneManBand3() {
	}

	public void perform() { // throws PerformanceException {
		for (Iterator iter = instruments.keySet().iterator(); iter.hasNext();) {
			String key = (String) iter.next();
			System.out.println(key + " : " + instruments.getProperty(key));
		}
	}

	// ���弯�����ԣ�ͨ��xmlע��װ��
	private Properties instruments;

	public void setInstruments(Properties instruments) {
		this.instruments = instruments;
	}
}
