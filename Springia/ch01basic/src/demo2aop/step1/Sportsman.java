package demo2aop.step1;

//‘À∂Ø‘±
public class Sportsman implements iPerson {
	private String name = "";
	
	public Sportsman(String name){
        this.name = name;
    }

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Hello, i am Sportsman!");
	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		System.out.println("Be training!");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		Track1.info("Calling play.");
		System.out.println(this.name + " is playing basketball!");
		Track2.info("After play.");
	}

}
