package web2017.team5.lini.ioc.byattributes;

public class Order {
	private IDataAccess ida;// ����һ��˽�б����������

	// ���ԣ���������
	public IDataAccess getIda() {
		return ida;
	}

	public void setIda(IDataAccess ida) {
		this.ida = ida;
	}

	public void add()
    {
        ida.add();
    }
}