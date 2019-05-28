package demo11;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

//使用Hibernate模板类进行数据操作
public class CustomerDaoHibTmpl {

	// injected
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTmpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//新增
	public void save(Customer c) {
        this.hibernateTemplate.save(c);
    }
	
	//修改
	public void update(Customer c) {
        this.hibernateTemplate.update(c);
    }
	
	//查询
	public Customer getCustomerById(Integer id) {
		return (Customer)this.hibernateTemplate.load(Customer.class, id);
	}
	
	//
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
	    String hql = "from Customer";
	    List<Customer> list = this.hibernateTemplate.find(hql);
	    return list;
	}
	
}
