package CurrencyExchange;
import java.sql.*;
import javax.swing.*;

public class SQLiteConnection {
	Connection connect = null;
	public static Connection databaseConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\james\\eclipse-workspace\\CurrencyExchange2\\src\\CurrencyExchange\\AccountInfo");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
