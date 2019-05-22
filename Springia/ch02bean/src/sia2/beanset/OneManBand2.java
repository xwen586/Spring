package sia2.beanset;

import java.util.Map;

//一个人的乐队，重点在对Bean的Map类装配
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

	// 定义集合属性，通过xml注入装配
	private Map<String, Instrument> instruments;
	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}
}
