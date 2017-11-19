package web2017.team4.wanglin.ioc.byinterface;

public class Order implements IDependent {
	private IDataAccess ida;// 定义一个私有变量保存抽象

	// 实现接口
	@Override
	public void SetDependence(IDataAccess ida) {
		this.ida = ida;
	}

	public void add() {
		ida.add();
	}

}
