package sia2.beandi;

//����һ������ң�ʵ��Performer�ӿ�
public class Instrumentalist implements Performer {
	public Instrumentalist() {
	}

	public void perform() { // throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}

	// ����ĸ���
	private String song;
	//setter������������ע��
	public void setSong(String song) {
		this.song = song;
	}

	// ���������
	private Instrument instrument;
	//setter������������ע��
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}
