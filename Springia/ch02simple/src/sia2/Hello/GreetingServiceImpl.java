package sia2.Hello;

public class GreetingServiceImpl implements GreetingService {
    private String greeting;

    public GreetingServiceImpl() {}

    public GreetingServiceImpl(String greeting) {
	    this.greeting = greeting;
    }

    public void setGreeting(String greeting) {
	    this.greeting = greeting;
    }

    @Override
    public void sayGreeting() {
    	System.out.println(greeting);
    }

}
