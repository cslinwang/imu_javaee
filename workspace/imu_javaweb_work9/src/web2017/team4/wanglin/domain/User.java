package web2017.team4.wanglin.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2636280193196906207L;

	/**
	 * User所有属性
	 */
	// 用户ID
	private int userId;
	// 用户名
	private String userName;
	// 用户密码
	private String password;
	// 积分
	private int credits;
	// 最后登录IP
	private String lastIp;
	// 最后登录时间
	private Date lastVisit;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Date getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(Date lastVisit) {
		this.lastVisit = lastVisit;
	}

}
