package web2017.team4.wanglin.ioc.byinterface;

public class Order implements IDependent {
	private IDataAccess ida;// ����һ��˽�б����������

	// ʵ�ֽӿ�
	@Override
	public void SetDependence(IDataAccess ida) {
		this.ida = ida;
	}

	public void add() {
		ida.add();
	}

}
