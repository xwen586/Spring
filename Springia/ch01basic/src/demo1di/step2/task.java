package demo1di.step2;

public class task {
    private String name;
    private javaCoder owner;
    
    public task(String name) {
        this.name =name;
        //this.owner = new javaCoder("zhang3"); //task�� �� ����Ա zhang3 ����һ��
    }
    
    //�ڹ��캯��ע����������
    public task(String name, javaCoder owner){
        this.name =name;
        this.owner = owner;
    }
    
    //ͨ������setOwnerע����������
    public void setOwner(javaCoder owner){
        this.owner = owner;
    }
    
    public void start(){
         System.out.println(this.name+ " started");
         this.owner.writeCode();
    }

}
