package web2017.team5.lini.ioc.byconstructor;

public class Order {
	private IDataAccess ida;// ����һ��˽�б����������

	public Order(IDataAccess ida) {
		this.ida  = ida;// ��������
	}
	
	public void add()
    {
		ida.add();
    }

}
