package com.turnrut.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;


public class DbUtils {
	private static DataSource datasource;
	static{
		try {
			InputStream in = DbUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			java.util.Properties prop = new java.util.Properties();
			prop.load(in);
			datasource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static DataSource getDataSource(){
		return datasource;
	}
	public static Connection getConnection(){
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
}
