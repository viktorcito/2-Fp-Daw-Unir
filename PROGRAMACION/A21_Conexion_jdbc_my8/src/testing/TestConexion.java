package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
	
		
		String url = "jdbc:mysql://localhost:3306/mysql_hr?serverTimezone=UTC";
		String user = "root";
		String password = "root";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("CONEXION ESTABLECIDA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("CONEXION NOOO ESTABLECIDA");
		}
		
		System.out.println("FIN DE PROGRAMA");

	}

}
