package web2017.team4.wanglin.vo;

public class User {
	private int id;
	private String name;
	private String password;
	private int age;
	public User(String name, String password) {
		// TODO Auto-generated constructor stub
		this.password=password;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
