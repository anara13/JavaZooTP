package org.formation.rasolofoharison.zoo.stockage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoJBDCConn {

	private static Connection conn;
	public DaoJBDCConn() {
		
		try {
			
			//Class.forName("com.mysql.jbdc.Driver");
			conn = DriverManager.getConnection("jbdc:mysql://localhost:3306/zoo/", "root", " ");
		 
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static Connection getConn() {
		return conn;
	}
	public static void main(String [] args) {
		DaoJBDCConn j = new DaoJBDCConn();
		System.out.println(j.getConn());
	}

}
