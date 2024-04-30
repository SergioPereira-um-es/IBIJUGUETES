package eventos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBBDD {
	
	private Connection connection;
	private String serverName = "sgbd.inf.um.es";
	private String portNumber = "1521";
	private String serviceName = "ORCLPDB";
	private String userName = "DSI03";
	private String password = "fargo";
	
	
	public Connection init() {
		try {
			String driverName = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driverName);
			String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + "/" + serviceName;
			connection = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver");
		} catch (SQLException e) {
			System.out.println(e.toString()); // No puede conectarse
		}
		System.out.println(connection.toString());
		return connection;
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
	}

}
