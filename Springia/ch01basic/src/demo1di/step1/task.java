package demo1di.step1;

public class task {
    private String name;
    private javaCoder owner;
    
    public task(String name){
        this.name =name;
        this.owner = new javaCoder("zhang3"); //task�� �� ����Ա zhang3 ����һ��
    }
    
    public void start(){
         System.out.println(this.name+ " started");
         this.owner.writeCode();
    }
}
