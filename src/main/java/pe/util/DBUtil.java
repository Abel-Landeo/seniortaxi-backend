package pe.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
		
	private static void readProperties() throws IOException {
		Properties props = new Properties();
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		props.load(in);
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
		in.close();
	}
	
	public static Connection getCon() {
		Connection con = null;
		try {
			readProperties();
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeResource(Object resource) {
		if(resource == null) return;
		try {
			if(resource instanceof Statement) ((Statement)resource).close();
			if(resource instanceof ResultSet) ((ResultSet)resource).close();
			if(resource instanceof Connection) ((Connection)resource).close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
