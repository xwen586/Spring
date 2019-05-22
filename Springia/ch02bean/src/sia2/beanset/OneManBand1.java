package sia2.beanset;

import java.util.Collection;

//一个人的乐队，重点在对Bean的集合类装配
public class OneManBand1 implements Performer {
	public OneManBand1() {
	}

	public void perform() { // throws PerformanceException {
		for (Instrument instrument : instruments) {
			instrument.play();
		}
	}

	// 定义集合属性，通过xml注入装配
	private Collection<Instrument> instruments;
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
}
