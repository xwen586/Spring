package sia2.Knight2;

//Ѱ��ʥ������ʵ����Quest�ӿ�
public class HolyGrailQuest implements Quest {	
	public HolyGrailQuest(){}
	
	public HolyGrail embark() throws GrailNotFoundException{
		System.out.println("Looking for grail ...");  //Ѱ��ʥ��
		
	    HolyGrail grail = new HolyGrail();
        return grail;
	}
}
