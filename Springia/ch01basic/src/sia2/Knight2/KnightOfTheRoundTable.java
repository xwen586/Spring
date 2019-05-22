/*
 * 亚瑟王的圆桌骑士
 */
package sia2.Knight2;

public class KnightOfTheRoundTable implements Knight {
    private String name;  //骑士姓名
    private Quest quest; //一项任务：寻找圣杯
  
    public KnightOfTheRoundTable(String name) {
        this.name = name;
        //this.quest = new HolyGrailQuest(); 通过set方法进行依赖项注入
    }

    public Object embarkOnQuest() throws QuestFailedException {
        System.out.println(this.name + " Start off !");  //出发
        return quest.embark(); //上船
    }

    /*********** 此处关键，是DI的操作点，通过xml配置，关联Knight与quest（骑士与任务）
     * knight被赋予了一个quest
     */
    public void setQuest(Quest quest) {
	    this.quest = quest;
	}
	  
    public String getName() {
        return name;
    }
    
}
