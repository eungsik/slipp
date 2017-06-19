package net.slipp.user;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
	
	private DataSource datasource;
	
	@Test
	public void test() {
		
		assertNotNull(datasource);
		
		//Connection connection = getConnection();		
		//assertNotNull(connection);
	}

	public Connection getConnection() {
		// JDBC driver name and database URL
		// String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/slipp_dev";
		String id = "root";
		String pw = "root";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}

		


	}

}
