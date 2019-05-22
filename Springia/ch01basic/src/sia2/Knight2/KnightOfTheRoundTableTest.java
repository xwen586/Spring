package sia2.Knight2;

import junit.framework.TestCase;

public class KnightOfTheRoundTableTest extends TestCase {

	public void testEmbarkOnQuest() { //throws GrailNotFoundException {
	    KnightOfTheRoundTable knight  = new KnightOfTheRoundTable("Bedivere");
	    HolyGrail grail;
		try {
			grail = (HolyGrail) knight.embarkOnQuest();
		    assertNotNull(grail);
		    assertTrue(grail.isHoly());
		    
		} catch (QuestFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
