package sia2.idol3;

//裁判的评论实现类，将被注入到裁判类中
public class CriticismEngineImpl implements CriticismEngine {
	public CriticismEngineImpl() {
	}

	public String getCriticism() {
		int i = (int) (Math.random() * criticismPool.length);
		return criticismPool[i];
	}

	// injected  注入评论结果池（字符串数组）
	private String[] criticismPool;
	public void setCriticismPool(String[] criticismPool) {
		this.criticismPool = criticismPool;
	}
}
