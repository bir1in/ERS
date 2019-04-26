package com.ERS.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Connection getConnection() {
		final Properties props = getJdbcProperties();
        //System.out.println("-------- Oracle JDBC Connection Testing ------");
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your JDBC Driver?");
            e.printStackTrace();
            return null;
        }
        //root@localhost:3306
        Connection connection = null;
        try {
        	connection = DriverManager.getConnection(props.getProperty("jdbc.url"), props.getProperty("jdbc.username"), props.getProperty("jdbc.password"));
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
	}
	
	public static void main(String[] args) {
		ConnectionManager.getConnection();
	}
	private static Properties getJdbcProperties() {
		Properties props = new Properties();
		try {
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ERS.properties"));
		} catch (IOException ex) {
			throw new RuntimeException("Failed to load application.properties");
		}
		return props;
	}
}
