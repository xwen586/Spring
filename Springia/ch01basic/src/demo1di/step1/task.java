package demo1di.step1;

public class task {
    private String name;
    private javaCoder owner;
    
    public task(String name){
        this.name =name;
        this.owner = new javaCoder("zhang3"); //task类 和 程序员 zhang3 绑定在一起
    }
    
    public void start(){
         System.out.println(this.name+ " started");
         this.owner.writeCode();
    }
}
