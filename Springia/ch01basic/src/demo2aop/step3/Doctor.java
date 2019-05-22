package demo2aop.step3;

public class Doctor implements iPerson {
	private String name = "";
	
	public Doctor(){}
	public Doctor(String name){
        this.name=name;
    }
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		//Track1.info("Calling sayHello.");
		System.out.println("Hello, i am doctor!");
		//Track2.info("Called sayHello.");
	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		System.out.println("Doctor be doing operation!");

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		//Track1.info("Calling play.");
		System.out.println("Dr." + this.name + " is playing the piano!");
		//Track2.info("After play.");
	}

}
