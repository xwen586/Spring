package sia2.Knight1;

public class KnightApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    KnightOfTheRoundTable knight  = new KnightOfTheRoundTable("Bedivere");
	    
	    //��ʿknight ��Ѱ��ʥ�� ������һ����ʿӦ������������
	    HolyGrail grail = knight.embarkOnQuest();
	    grail.isHoly();
	}

}
