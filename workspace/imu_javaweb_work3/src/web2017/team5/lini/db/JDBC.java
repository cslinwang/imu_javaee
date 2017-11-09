package web2017.team5.lini.db;
//连接数据库
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC {
	public static Connection getConnection() {
		Connection con=null;
		try {		 
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imu","root","mysql");
			System.out.println("成功连接...");//验证是否成功
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return con;
	}
	

}
