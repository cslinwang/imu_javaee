package web2017.team5.lini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web2017.team5.lini.db.JDBC;

//对数据库进行操作
public class UserDao {
	public int addUser(String name, String password) {
		int num = 0;	
		try {
			Connection con = JDBC.getConnection();// 连接数据库
			String sql = "insert into user(name,password) values(?,?)";// 数据库操作语句
			PreparedStatement ps = con.prepareStatement(sql);// 预编译
			ps.setString(1, name);
			ps.setString(2, password);
			System.out.println(name);
			num = ps.executeUpdate();// 执行语句
			//释放资源
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
	}

	public int selectByNamePassword(String name, String password) {
		// TODO Auto-generated method stub
		int num = 0;
		ResultSet rs = null;
		try {

			Connection con = JDBC.getConnection();// 连接数据库
			if (con == null) {
				throw new SQLException("con is null");
			}
			String sql = "select * from user where name = ? and password = ?";// 数据库操作语句
			PreparedStatement ps = con.prepareStatement(sql);// 预编译
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("Id");
				String newname = rs.getString("name");
				String newpassword = rs.getString("password");
				// System.out.println(id + "\t" + newname + "\t" + newpassword);
				num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;

	}
}
