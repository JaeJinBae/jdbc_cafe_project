package kr.or.dgit.jdbc_cafe_project.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static final DBCon instance = new DBCon();
	private Connection connection;

	public static void main(String[] args) {
		DBCon dbcon=new DBCon();
	}
	
	public static DBCon getInstance() {
		return instance;
	}

	private DBCon(){
		Properties properties = getProperties("conf.properties");
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pwd"));
		} catch (SQLException e) {
			System.err.printf("%s - %s%n", e.getErrorCode(), e.getMessage());
			e.printStackTrace();
		}
	//	System.out.println(properties.getProperty("user"));
	//	System.out.println(properties.getProperty("pwd"));
	//	System.out.println(properties.getProperty("url"));
	}
	
	private Properties getProperties(String propertiesPath) {
		Properties properties = new Properties();
		InputStream is = ClassLoader.getSystemResourceAsStream(propertiesPath);
		try {
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public Connection getConnection() {
		return connection;
	}

	

}
