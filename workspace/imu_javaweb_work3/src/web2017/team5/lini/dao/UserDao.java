package web2017.team5.lini.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import web2017.team5.lini.db.JDBC;

//�����ݿ���в���
public class UserDao {
	public int addUser(String name, String password) {
		int num = 0;	
		try {
			Connection con = JDBC.getConnection();// �������ݿ�
			String sql = "insert into user(name,password) values(?,?)";// ���ݿ�������
			PreparedStatement ps = con.prepareStatement(sql);// Ԥ����
			ps.setString(1, name);
			ps.setString(2, password);
			System.out.println(name);
			num = ps.executeUpdate();// ִ�����
			//�ͷ���Դ
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

			Connection con = JDBC.getConnection();// �������ݿ�
			if (con == null) {
				throw new SQLException("con is null");
			}
			String sql = "select * from user where name = ? and password = ?";// ���ݿ�������
			PreparedStatement ps = con.prepareStatement(sql);// Ԥ����
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
