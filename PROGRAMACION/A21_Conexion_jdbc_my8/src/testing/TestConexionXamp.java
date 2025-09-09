package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexionXamp {

	public static void main(String[] args) {
		
		
		String urlXampp = "jdbc:mysql://localhost:3307/test";
		
		String user = "root";
		String passwordXampp = "";
		
		try {
			Connection conn = DriverManager.getConnection(urlXampp, user, passwordXampp);
			System.out.println("CONEXION ESTABLECIDA");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			System.out.println("CONEXION NOOO ESTABLECIDA");
		}
		
		System.out.println("FIN DE PROGRAMA");

	}

}
