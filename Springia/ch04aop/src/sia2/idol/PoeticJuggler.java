package sia2.idol;

//��ʫ��ħ��ʦ
public class PoeticJuggler extends Juggler {
	//private Poem poem;

	public PoeticJuggler(int beanBags) {
		super(beanBags);
	}

	public void perform() {// throws PerformanceException 
		super.perform();
		System.out.println("While reciting...");
	}
}
