package demo01;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

//iBatis的API核心是SqlMapClient
public class CustomerDao {

	// injected
	private SqlMapClient sqlMapClient = null;
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	
	// 读取配置文件SqlMapConfig.xml，解读Student.xml
	/*
    static {
        try {
            Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    public List<Customer> selectAll() {
        List<Customer> customers = null;
        try {
            //selectAllStudent是Student.xml配置中的id
        	customers = sqlMapClient.queryForList("selectAll");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer selectById(int id) {
    	Customer customer = null;
        try {
            /*
             * Student.xml中parameterClass="int"，也就是需要一个int参数
             * Student.xml中resultClass="Student"，也就是查询结果封装到Student类
             */
        	customer = (Customer) sqlMapClient.queryForObject(
                    "selectStudentById", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    //新增
    public void insert(Customer customer) throws SQLException {  
    	sqlMapClient.insert("addCustomer", customer);  
    }
    
    //删除
    public void delete(Customer customer) throws SQLException {  
    	sqlMapClient.insert("deleteById", customer);  
    }
    
    public boolean update(Customer customer) {
        boolean flag = false;
        Object object = false;
        try {
            /*
             * student对象作为参数，会对应Student.xml中配置的参数，通过getter取值
             */
            object = sqlMapClient.update("updCustomer", customer);
            System.out.println("更新信息的返回值：" + object + "，返回影响的行数");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (object != null) {
            flag = true;
        }
        return flag;
    }
    
}
