package demo11;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

//ʹ��Hibernateģ����������ݲ���
public class CustomerDaoHibTmpl {

	// injected
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTmpl(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//����
	public void save(Customer c) {
        this.hibernateTemplate.save(c);
    }
	
	//�޸�
	public void update(Customer c) {
        this.hibernateTemplate.update(c);
    }
	
	//��ѯ
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
