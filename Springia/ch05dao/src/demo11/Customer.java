package demo11;

/* ”√ªß¿‡
 * create table Customer(id integer primary key, name text, age integer, phone text);
 * insert into Customer(id, name, age, phone) values(1, 'Micheal', 12, 010-0255);
 * select * from Customer;
 */
public class Customer {
    private Integer id;
    private String name;
    private int age;
    private String phone;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer:[id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + "]";
    }

}
