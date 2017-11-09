package web2017.team5.lini.ioc.byinterface;

public class Test {
	public static void main(String[] args) {
		 AccessDal dal = new AccessDal();//在外部创建依赖对象
         Order order = new Order();
		order.SetDependence(dal);
		order.add();
		
		
	}
}
