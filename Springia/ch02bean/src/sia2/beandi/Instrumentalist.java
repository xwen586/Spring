package sia2.beandi;

//定义一个演奏家，实现Performer接口
public class Instrumentalist implements Performer {
	public Instrumentalist() {
	}

	public void perform() { // throws PerformanceException {
		System.out.print("Playing " + song + " : ");
		instrument.play();
	}

	// 演奏的歌曲
	private String song;
	//setter方法，做参数注入
	public void setSong(String song) {
		this.song = song;
	}

	// 演奏的乐器
	private Instrument instrument;
	//setter方法，做对象注入
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
}
