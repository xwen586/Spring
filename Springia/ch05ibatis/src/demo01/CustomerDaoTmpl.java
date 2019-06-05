package demo01;

import java.util.List;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

//��DAO��ʹ��ģ��
//Spring��iBatis��Ϻ���SqlMapClientTemplate�����iBatis�Ự������쳣����
public class CustomerDaoTmpl {

	// injected
	private SqlMapClientTemplate sqlMapClientTemplate;
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	    this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

    //����
    public void insert(Customer customer) {  
    	sqlMapClientTemplate.insert("addCustomer", customer);  
    }
    
    //ɾ��
    public void delete(Customer customer) {  
    	sqlMapClientTemplate.insert("deleteById", customer);  
    }
    
    //�޸�
    public boolean update(Customer customer) {
        boolean flag = false;
        Object object = false;

		object = sqlMapClientTemplate.update("updCustomer", customer);
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
		customers = sqlMapClientTemplate.queryForList("selectAll");
        return customers;
    }

    public Customer selectById(int id) {
    	Customer customer = null;
        /*
		 * Customer.xml��parameterClass="int"��Ҳ������Ҫһ��int����
		 * Customer.xml��resultClass="Customer"��Ҳ���ǲ�ѯ�����װ��Customer��
		 */
		customer = (Customer) sqlMapClientTemplate.queryForObject(
		        "selectById", id);
        return customer;
    }

}
