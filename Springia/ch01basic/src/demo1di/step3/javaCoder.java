package demo1di.step3;

public class javaCoder implements coder {
    private String name;
    
    public javaCoder(String name){
        this.name=name;
    }
    
    public void writeCode(){
        System.out.println(this.name + " is writing Java code!");
    }
}
