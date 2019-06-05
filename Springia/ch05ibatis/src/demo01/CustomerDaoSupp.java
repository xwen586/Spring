package demo01;

import java.util.List;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

//使用基于iBatis的DAO支持类，可使Spring少配置一个Bean
//Spring与iBatis结合后是SqlMapClientTemplate，解决iBatis会话管理和异常处理
public class CustomerDaoSupp extends SqlMapClientDaoSupport {

	// injected
	//private SqlMapClientTemplate sqlMapClientTemplate;
	//public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	//    this.sqlMapClientTemplate = sqlMapClientTemplate;
	//}

    //新增
    public void insert(Customer customer) {  
    	this.getSqlMapClientTemplate().insert("addCustomer", customer);  
    }
    
    //删除
    public void delete(Customer customer) {  
    	this.getSqlMapClientTemplate().insert("deleteById", customer);  
    }
    
    //修改
    public boolean update(Customer customer) {
        boolean flag = false;
        Object object = false;

		object = this.getSqlMapClientTemplate().update("updCustomer", customer);
        if (object != null) {
    		System.out.println("更新信息的返回值：" + object + "，返回影响的行数");
            flag = true;
        }
        return flag;
    }
    
    @SuppressWarnings("unchecked")
	public List<Customer> selectAll() {
        List<Customer> customers = null;
        //selectAll是Customer.xml配置中的id
		customers = this.getSqlMapClientTemplate().queryForList("selectAll");
        return customers;
    }

    public Customer selectById(int id) {
    	Customer customer = null;
        /*
		 * Customer.xml中parameterClass="int"，也就是需要一个int参数
		 * Customer.xml中resultClass="Customer"，也就是查询结果封装到Customer类
		 */
		customer = (Customer) this.getSqlMapClientTemplate().queryForObject(
		        "selectById", id);
        return customer;
    }

}
