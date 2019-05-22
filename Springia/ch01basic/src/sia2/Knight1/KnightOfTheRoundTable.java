/*
 * 亚瑟王的圆桌骑士
 */
package sia2.Knight1;

public class KnightOfTheRoundTable {
  private String name;  //骑士姓名
  private HolyGrailQuest quest; //一项任务：寻找圣杯
  
  public KnightOfTheRoundTable(String name) {
    this.name = name;
    
    /*骑士与
     */
    this.quest = new HolyGrailQuest();
  }

  public HolyGrail embarkOnQuest() {//throws GrailNotFoundException{
	  System.out.println(this.name + " Start off !");  //出发
      return quest.embark(); //上船
  }
}
