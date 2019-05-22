package sia2.Knight1;

import junit.framework.TestCase;

public class KnightOfTheRoundTableTest extends TestCase {

	public void testEmbarkOnQuest() { //throws GrailNotFoundException {
	    KnightOfTheRoundTable knight  = new KnightOfTheRoundTable("Bedivere");
	    HolyGrail grail = knight.embarkOnQuest();
	    assertNotNull(grail);
	    assertTrue(grail.isHoly());
	}
}
