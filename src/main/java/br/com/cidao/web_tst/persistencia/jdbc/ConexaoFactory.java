package br.com.cidao.web_tst.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	public static Connection getConnection() {
		Connection c=null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
			.getConnection("jdbc:postgresql://localhost:5432/web_tst", "postgres","210910");
		} catch (SQLException e) {
			//Wrapper de Exception
			throw new RuntimeException("não conectou!", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}
