package web2017.team5.lini.ioc.byattributes;

public class Test {
	public static void main(String[] args) {
		SqlServerDal dal = new SqlServerDal();// ���ⲿ������������
		Order order = new Order();// ͨ�����캯��ע������
		order.setIda(dal);
		order.add();
		
		
	}
}
