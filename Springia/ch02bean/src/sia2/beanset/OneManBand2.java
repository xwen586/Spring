package sia2.beanset;

import java.util.Map;

//һ���˵��ֶӣ��ص��ڶ�Bean��Map��װ��
public class OneManBand2 implements Performer {
	public OneManBand2() {
	}

	public void perform() { // throws PerformanceException {
		for (String key : instruments.keySet()) {
			System.out.print(key + ": ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}

	// ���弯�����ԣ�ͨ��xmlע��װ��
	private Map<String, Instrument> instruments;
	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}
}
