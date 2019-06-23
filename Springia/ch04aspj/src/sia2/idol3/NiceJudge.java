package sia2.idol3;

public class NiceJudge {
	public NiceJudge() {
	}

	public void greetPerformer() {
		System.out.println("<aop:before> GREETING PERFORMER");
	}

	public void saySomethingNice() {
		System.out.println("<aop:after> THAT WAS GREAT");
	}

	public void saySomethingNiceAnyway() {
		System.out.println("<aop:after-throwing> IT WASN'T GREAT, BUT I LOVE YOU ANYWAY");
	}
}
