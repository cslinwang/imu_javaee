package web2017.team5.lini.ioc.byconstructor;

public class Test {
	public static void main(String[] args) {
		SqlServerDal dal = new SqlServerDal();// ���ⲿ������������
		Order order = new Order(dal);// ͨ�����캯��ע������
		order.add();
		
		AccessDal dal1 = new AccessDal();//���ⲿ������������
        Order order1 = new Order(dal1);//ͨ�����캯��ע������
        order1.add();
	}
}
