package sia2.beanset;

import java.util.Collection;

//һ���˵��ֶӣ��ص��ڶ�Bean�ļ�����װ��
public class OneManBand1 implements Performer {
	public OneManBand1() {
	}

	public void perform() { // throws PerformanceException {
		for (Instrument instrument : instruments) {
			instrument.play();
		}
	}

	// ���弯�����ԣ�ͨ��xmlע��װ��
	private Collection<Instrument> instruments;
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
}
