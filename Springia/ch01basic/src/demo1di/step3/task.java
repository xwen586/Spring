package demo1di.step3;

public class task {
    private String name;
    private coder owner;   //javaCoder改为接口coder
    
    public task(String name) {
        this.name =name;
    }
    
    //在构造函数注入依赖对象
    public task(String name, coder owner){
        this.name =name;
        this.owner = owner;
    }
    
    //通过方法setOwner注入依赖对象
    public void setOwner(coder owner){
        this.owner = owner;
    }
    
    public void start(){
         System.out.println(this.name + " started");
         this.owner.writeCode();
    }

}
