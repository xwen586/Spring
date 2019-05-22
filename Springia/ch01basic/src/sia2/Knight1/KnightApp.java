package sia2.Knight1;

public class KnightApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    KnightOfTheRoundTable knight  = new KnightOfTheRoundTable("Bedivere");
	    
	    //骑士knight 与寻找圣杯 捆绑在一起，骑士应还有其他任务
	    HolyGrail grail = knight.embarkOnQuest();
	    grail.isHoly();
	}

}
