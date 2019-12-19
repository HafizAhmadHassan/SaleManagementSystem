package db;

import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {

	public static Connection createConnection()
	{
		Connection con = null;
		String url = "jdbc:sqlserver://localhost;databaseName=SalesManagement;integratedSecurity=true;";
		//String url = "jdbc:sqlserver://[ANS-PC[\SQLEXPRESS01]][;databaseName=SalesManagement[;integratedSecurity=true]]";
		try 
		{
			try 
			{
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			} 
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			} 
			con = DriverManager.getConnection(url); //attempting to connect to MySQL database
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con; 
	}
}
