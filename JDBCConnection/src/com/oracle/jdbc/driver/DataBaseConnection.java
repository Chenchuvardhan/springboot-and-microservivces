package com.oracle.jdbc.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DataBaseConnection {
public static void main(String[] args)throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","chenchu","lion");
	PreparedStatement statement=connection.prepareStatement("select * from employee");
	ResultSet rset=statement.executeQuery();
	while(rset.next()) {
		System.out.println(rset.getInt(0));
	}
	}
}