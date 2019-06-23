package sia2.idol3;

public aspect JudgeAspect {
	public JudgeAspect() {}
	
	pointcut performance() : execution(* perform(..));
	
	after() returning() : performance() {
	    System.out.println(criticismEngine.getCriticism());
	}
	
	
	// injected  ����ע��������
	private CriticismEngine criticismEngine;

	public void setCriticismEngine(CriticismEngine criticismEngine) {
		this.criticismEngine = criticismEngine;
	}
}
