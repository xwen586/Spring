/*
 * ��ɪ����Բ����ʿ
 */
package sia2.Knight1;

public class KnightOfTheRoundTable {
  private String name;  //��ʿ����
  private HolyGrailQuest quest; //һ������Ѱ��ʥ��
  
  public KnightOfTheRoundTable(String name) {
    this.name = name;
    
    /*��ʿ��
     */
    this.quest = new HolyGrailQuest();
  }

  public HolyGrail embarkOnQuest() {//throws GrailNotFoundException{
	  System.out.println(this.name + " Start off !");  //����
      return quest.embark(); //�ϴ�
  }
}
