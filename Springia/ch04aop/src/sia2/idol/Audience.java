package sia2.idol;

//观众，切面织入行为
public class Audience {
	public Audience() {
	}

	//就座
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	//关闭手机
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	//鼓掌
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	//要求退票
	public void demandRefund() {
		System.out.println("Boo! We want our money back!");
	}
}
