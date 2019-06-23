package demo1;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

//ע�ⷨcache
public class myService {

	@Cacheable(value="myCache",key="#id")  //--��ӻ���
	public int query(int id){
		System.out.println("query, key=" + id);
		return id;
	}

	@Cacheable(value = "myCache", key = "#str")
	public String querystr(String str) {
		System.out.println("query str");
		return "123";
	}

	@CacheEvict(value = "myCache") // ---ɾ������
	public void update() {
		System.out.println("update");
	}

}
