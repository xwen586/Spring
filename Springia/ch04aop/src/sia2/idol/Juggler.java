package sia2.idol;

//魔术师，派生自表演
public class Juggler implements Performer {
  private int beanBags = 3;
  
  public Juggler() {}
  
  public Juggler(int beanBags) {
    this.beanBags = beanBags;  
  }

  public void perform() {
    System.out.println("JUGGLING " + beanBags + " BEANBAGS");
  }
}
