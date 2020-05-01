package CurrencyExchange;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AccountBalance extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountBalance frame = new AccountBalance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Begin SQLite connection
	Connection connection = null;
	private JTable table;
	/**
	 * Create the frame.
	 */
	public AccountBalance() {
		// Connection Statement
		connection = SQLiteConnection.databaseConnection();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Balance");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 94, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Return to the Main Menu :");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(203, 236, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				MainMenu.main(null);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton.setBounds(335, 232, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 11));
		textField.setBounds(212, 75, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(145, 78, 57, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Enter your username in order to load your info.");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(120, 44, 211, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton loadButton = new JButton("Load Data");
		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select Dollar,Euro,Yen from AccountInfo where username= '" + textField.getText() + "'  ";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					ResultSet resultSet = preparedStatement.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(resultSet));
				}catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		loadButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		loadButton.setBounds(178, 106, 94, 23);
		contentPane.add(loadButton);
		
		table = new JTable();
		table.setFont(new Font("Calibri", Font.PLAIN, 14));
		table.setBounds(120, 176, 211, 14);
		contentPane.add(table);
		
		JLabel lblNewLabel_4 = new JLabel("Dollars ($)");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(120, 161, 48, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Euros (\u20AC)");
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(190, 161, 48, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Yen (\u00A5)");
		lblNewLabel_6.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(262, 161, 48, 14);
		contentPane.add(lblNewLabel_6);
	}
}
