package sia2.bean;

//魔术师，派生自表演
public class Juggler implements Performer {
  private int beanBags = 3;
  
  public Juggler() {}
  
  public Juggler(int beanBags) {
    this.beanBags = beanBags;  
  }

  public void perform() throws PerformanceException {
    System.out.println("JUGGLING " + beanBags + " BEANBAGS");
  }
}
