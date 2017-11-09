package web2017.team5.lini.service;

import web2017.team5.lini.dao.UserDao;

public class LoginService {
	UserDao ud = new UserDao();

	public Boolean loginNoSql(String name, String password) {
		if (name.equals("ma") && password.equals("123")) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean loginService(String name, String password) {
		int num = ud.selectByNamePassword(name,password);
		if(num==0){
			return false;
		}
		return true;
	}

}
