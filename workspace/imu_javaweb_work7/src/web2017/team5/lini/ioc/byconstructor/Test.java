package web2017.team5.lini.ioc.byconstructor;

public class Test {
	public static void main(String[] args) {
		SqlServerDal dal = new SqlServerDal();// 在外部创建依赖对象
		Order order = new Order(dal);// 通过构造函数注入依赖
		order.add();
		
		AccessDal dal1 = new AccessDal();//在外部创建依赖对象
        Order order1 = new Order(dal1);//通过构造函数注入依赖
        order1.add();
	}
}
