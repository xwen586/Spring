package demo01;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

//iBatis��API������SqlMapClient
public class CustomerDao {

	// injected
	private SqlMapClient sqlMapClient = null;
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	
	// ��ȡ�����ļ�SqlMapConfig.xml�����Student.xml
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
            //selectAllStudent��Student.xml�����е�id
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
             * Student.xml��parameterClass="int"��Ҳ������Ҫһ��int����
             * Student.xml��resultClass="Student"��Ҳ���ǲ�ѯ�����װ��Student��
             */
        	customer = (Customer) sqlMapClient.queryForObject(
                    "selectStudentById", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    //����
    public void insert(Customer customer) throws SQLException {  
    	sqlMapClient.insert("addCustomer", customer);  
    }
    
    //ɾ��
    public void delete(Customer customer) throws SQLException {  
    	sqlMapClient.insert("deleteById", customer);  
    }
    
    public boolean update(Customer customer) {
        boolean flag = false;
        Object object = false;
        try {
            /*
             * student������Ϊ���������ӦStudent.xml�����õĲ�����ͨ��getterȡֵ
             */
            object = sqlMapClient.update("updCustomer", customer);
            System.out.println("������Ϣ�ķ���ֵ��" + object + "������Ӱ�������");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (object != null) {
            flag = true;
        }
        return flag;
    }
    
}
