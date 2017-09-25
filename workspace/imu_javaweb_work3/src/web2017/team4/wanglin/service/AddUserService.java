package web2017.team4.wanglin.service;

import web2017.team4.wanglin.dao.UserDao;
import web2017.team4.wanglin.vo.User;

public class AddUserService {
	public boolean addUser(String name, String password) {
		UserDao dao = new UserDao();
		int num = dao.addUser(name, password);
		if (num >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
