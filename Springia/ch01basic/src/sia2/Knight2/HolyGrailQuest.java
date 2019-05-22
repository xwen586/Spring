package sia2.Knight2;

//寻找圣杯任务，实现自Quest接口
public class HolyGrailQuest implements Quest {	
	public HolyGrailQuest(){}
	
	public HolyGrail embark() throws GrailNotFoundException{
		System.out.println("Looking for grail ...");  //寻找圣杯
		
	    HolyGrail grail = new HolyGrail();
        return grail;
	}
}
