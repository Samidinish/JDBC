package jdbc;

import java.beans.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDB {
	Connection connect = null;
	Statement statement = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public static Properties loadProperties() throws IOException{
		Properties prop = new Properties();
		InputStream ism = new FileInputStream("src\\MySql.properties");
		prop.load(ism);
		ism.close();
		
		return prop;
	}
	public void connectToDatabase() throws IOException, SQLException, ClassNotFoundException {
		Properties prop = loadProperties();
		String driverClass = prop.getProperty("MYSQLJDBC.driver");
		String url = prop.getProperty("MYSQLJDBC.url");
		String userName = prop.getProperty("MYSQLJDBC.userName");
		String password = prop.getProperty("MYSQLJDBC.password");
		Class.forName(driverClass);
		connect = DriverManager.getConnection(url,userName,password);
		System.out.println("Database is connected");
	
	}


}
