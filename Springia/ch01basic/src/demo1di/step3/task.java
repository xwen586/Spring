package demo1di.step3;

public class task {
    private String name;
    private coder owner;   //javaCoder��Ϊ�ӿ�coder
    
    public task(String name) {
        this.name =name;
    }
    
    //�ڹ��캯��ע����������
    public task(String name, coder owner){
        this.name =name;
        this.owner = owner;
    }
    
    //ͨ������setOwnerע����������
    public void setOwner(coder owner){
        this.owner = owner;
    }
    
    public void start(){
         System.out.println(this.name + " started");
         this.owner.writeCode();
    }

}
