package web2017.team4.wanglin.ioc.byconstructor;

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