/*
 * ��ɪ����Բ����ʿ
 */
package sia2.Knight2;

public class KnightOfTheRoundTable implements Knight {
    private String name;  //��ʿ����
    private Quest quest; //һ������Ѱ��ʥ��
  
    public KnightOfTheRoundTable(String name) {
        this.name = name;
        //this.quest = new HolyGrailQuest(); ͨ��set��������������ע��
    }

    public Object embarkOnQuest() throws QuestFailedException {
        System.out.println(this.name + " Start off !");  //����
        return quest.embark(); //�ϴ�
    }

    /*********** �˴��ؼ�����DI�Ĳ����㣬ͨ��xml���ã�����Knight��quest����ʿ������
     * knight��������һ��quest
     */
    public void setQuest(Quest quest) {
	    this.quest = quest;
	}
	  
    public String getName() {
        return name;
    }
    
}
