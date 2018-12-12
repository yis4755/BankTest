package money;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

	public Connection connection() throws Exception {
		// 드라이버 셋팅
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("드라이버 셋팅 완료");
		
		//	DB 연결
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("DB 연결 성공");
		return con;
	}
}
