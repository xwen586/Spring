package demo01;

import java.util.List;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

//在DAO里使用模板
//Spring与iBatis结合后是SqlMapClientTemplate，解决iBatis会话管理和异常处理
public class CustomerDaoTmpl {

	// injected
	private SqlMapClientTemplate sqlMapClientTemplate;
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
	    this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

    //新增
    public void insert(Customer customer) {  
    	sqlMapClientTemplate.insert("addCustomer", customer);  
    }
    
    //删除
    public void delete(Customer customer) {  
    	sqlMapClientTemplate.insert("deleteById", customer);  
    }
    
    //修改
    public boolean update(Customer customer) {
        boolean flag = false;
        Object object = false;

		object = sqlMapClientTemplate.update("updCustomer", customer);
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
		customers = sqlMapClientTemplate.queryForList("selectAll");
        return customers;
    }

    public Customer selectById(int id) {
    	Customer customer = null;
        /*
		 * Customer.xml中parameterClass="int"，也就是需要一个int参数
		 * Customer.xml中resultClass="Customer"，也就是查询结果封装到Customer类
		 */
		customer = (Customer) sqlMapClientTemplate.queryForObject(
		        "selectById", id);
        return customer;
    }

}
