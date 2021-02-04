package fr.isen.java2.db.daos;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public class DataSourceFactory {

	private static Connection dataSource = null;
	private static String url = "jdbc:sqlite:sqlite.db";

	DataSourceFactory() {
		// This is a static class that should not be instantiated.
		// Here's a way to remember it when this class will have 2K lines and you come
		// back to it in 2 years
		throw new IllegalStateException("This is a static class that should not be instantiated");
	}

	/**
	 * @return a connection to the SQLite Database
	 * 
	 */
	public static Connection getDataSource() {
		try{
			dataSource = DriverManager.getConnection(url);
			return dataSource;
		}
		catch (SQLException e){
			return null;
		}
	}
}