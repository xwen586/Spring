package demo01;

import java.util.List;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

//ʹ�û���iBatis��DAO֧���࣬��ʹSpring������һ��Bean
//Spring��iBatis��Ϻ���SqlMapClientTemplate�����iBatis�Ự������쳣����
public class CustomerDaoSupp extends SqlMapClientDaoSupport {

	// injected
	//private SqlMapClientTemplate sqlMapClientTemplate;
	//public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	//    this.sqlMapClientTemplate = sqlMapClientTemplate;
	//}

    //����
    public void insert(Customer customer) {  
    	this.getSqlMapClientTemplate().insert("addCustomer", customer);  
    }
    
    //ɾ��
    public void delete(Customer customer) {  
    	this.getSqlMapClientTemplate().insert("deleteById", customer);  
    }
    
    //�޸�
    public boolean update(Customer customer) {
        boolean flag = false;
        Object object = false;

		object = this.getSqlMapClientTemplate().update("updCustomer", customer);
        if (object != null) {
    		System.out.println("������Ϣ�ķ���ֵ��" + object + "������Ӱ�������");
            flag = true;
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
	public List<Customer> selectAll() {
        List<Customer> customers = null;
        //selectAll��Customer.xml�����е�id
		customers = this.getSqlMapClientTemplate().queryForList("selectAll");
        return customers;
    }

    public Customer selectById(int id) {
    	Customer customer = null;
        /*
		 * Customer.xml��parameterClass="int"��Ҳ������Ҫһ��int����
		 * Customer.xml��resultClass="Customer"��Ҳ���ǲ�ѯ�����װ��Customer��
		 */
		customer = (Customer) this.getSqlMapClientTemplate().queryForObject(
		        "selectById", id);
        return customer;
    }

}
