package br.edu.unicid.util;

import java.sql.*;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_estoque", "root", "");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void main(String args[]) {
		try {
			ConnectionFactory.getConnection();
			JOptionPane.showMessageDialog(null, "Banco conectado!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection connection, Statement stmt, ResultSet rs) throws Exception {
		close(connection, stmt, rs);
	}

	public static void closeConnection(Connection connection, Statement stmt) throws Exception {
		close(connection, stmt, null);
	}

	public static void closeConnection(Connection connection) throws Exception {
		close(connection, null, null);
	}

	private static void close(Connection connection, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
