package demo1di.step2;

public class task {
    private String name;
    private javaCoder owner;
    
    public task(String name) {
        this.name =name;
        //this.owner = new javaCoder("zhang3"); //task类 和 程序员 zhang3 绑定在一起
    }
    
    //在构造函数注入依赖对象
    public task(String name, javaCoder owner){
        this.name =name;
        this.owner = owner;
    }
    
    //通过方法setOwner注入依赖对象
    public void setOwner(javaCoder owner){
        this.owner = owner;
    }
    
    public void start(){
         System.out.println(this.name+ " started");
         this.owner.writeCode();
    }

}
