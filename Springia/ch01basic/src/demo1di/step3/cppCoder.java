package demo1di.step3;

public class cppCoder implements coder {
	private String name;
	
    public cppCoder(String name){
        this.name=name;
    }
    
	@Override
	public void writeCode() {
		// TODO Auto-generated method stub
        System.out.println(this.name + " is writing CPP code!");
	}

}
