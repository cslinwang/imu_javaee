package web2017.team4.wanglin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web2017.team4.wanglin.dao.LoginLogDao;
import web2017.team4.wanglin.dao.UserDao;
import web2017.team4.wanglin.domain.LoginLog;
import web2017.team4.wanglin.domain.User;

/**
 * 这边来调用两个dao层的方法
 * @author shengdong252
 *
 */
@Service
public class UserService {
	//注入两个dao
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	//调用方法
	public boolean hasMatchUser(String userName, String password) {
		int matchCount =userDao.getMatchCount(userName, password);
		return matchCount > 0;
	}
	
	public User findUserByUserName(String userName){
		return userDao.findUserByUserName(userName);
	}
	
	//登录成功后添加日志信息
	public void loginSuccess(User user){
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	
	public void register(User user){
		userDao.register(user);
	}
	
	public List<User> getUserList(){
		return userDao.getUserList();
	}
	
	public void deleteUser(User user){
		userDao.deleteUser(user);
	}
	
	public void modifyUser(User user){
		userDao.modifyUser(user);
	}

}
