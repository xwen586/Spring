package demo2aop.step1;

public class mainApp {

	public static void main(String[] args) {
		iPerson doctor = new Doctor("Tom");
		iPerson sports = new Sportsman("M.Jordan");

		doctor.sayHello();
		sports.play();
	}
}
