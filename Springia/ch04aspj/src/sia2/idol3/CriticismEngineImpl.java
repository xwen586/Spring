package sia2.idol3;

//���е�����ʵ���࣬����ע�뵽��������
public class CriticismEngineImpl implements CriticismEngine {
	public CriticismEngineImpl() {
	}

	public String getCriticism() {
		int i = (int) (Math.random() * criticismPool.length);
		return criticismPool[i];
	}

	// injected  ע�����۽���أ��ַ������飩
	private String[] criticismPool;
	public void setCriticismPool(String[] criticismPool) {
		this.criticismPool = criticismPool;
	}
}
