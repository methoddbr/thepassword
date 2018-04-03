/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class dbUtil {
	
	public static Connection getConnetion(){
		Connection connection = null;
		String driverJDBC = "org.hsqldb.jdbcDriver";		
		String urlConexao = "jdbc:hsqldb:hsql://localhost";
		                    
		String userConnection  = "sa";
		String passwordConn  = "";
		
		try {
			Class.forName(driverJDBC);
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(urlConexao, userConnection, passwordConn);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void closeConnection(Connection con) {
		
	}
	
}
