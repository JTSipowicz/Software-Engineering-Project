package CurrencyExchange;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField userTextField;
	private JTextField passTextField;
	private JTextField emailTextField;
	private JTextField accountTypeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Begin SQLite connection
		Connection connection = null;
	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Connection Statement
		connection = SQLiteConnection.databaseConnection();

		
		JLabel MenuLabel = new JLabel("Registration Page");
		MenuLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		MenuLabel.setBounds(10, 11, 118, 14);
		contentPane.add(MenuLabel);
		
		JLabel userLabel = new JLabel("Username :");
		userLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		userLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		userLabel.setBounds(128, 69, 71, 14);
		contentPane.add(userLabel);
		
		JLabel passLabel = new JLabel("Password :");
		passLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		passLabel.setBounds(151, 94, 48, 14);
		contentPane.add(passLabel);
		
		JLabel emailLabel = new JLabel("Email :");
		emailLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		emailLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		emailLabel.setBounds(151, 121, 48, 14);
		contentPane.add(emailLabel);
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("Calibri", Font.PLAIN, 11));
		userTextField.setBounds(209, 66, 96, 20);
		contentPane.add(userTextField);
		userTextField.setColumns(10);
		
		passTextField = new JTextField();
		passTextField.setFont(new Font("Calibri", Font.PLAIN, 11));
		passTextField.setBounds(209, 91, 96, 20);
		contentPane.add(passTextField);
		passTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Calibri", Font.PLAIN, 11));
		emailTextField.setBounds(209, 116, 96, 20);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);
		
		accountTypeTextField = new JTextField();
		accountTypeTextField.setFont(new Font("Calibri", Font.PLAIN, 11));
		accountTypeTextField.setBounds(209, 141, 96, 20);
		contentPane.add(accountTypeTextField);
		accountTypeTextField.setColumns(10);
		
		JLabel accountTypeLabel = new JLabel("Account Type : ");
		accountTypeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		accountTypeLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		accountTypeLabel.setBounds(128, 144, 71, 14);
		contentPane.add(accountTypeLabel);
		
		JButton registrationButton = new JButton("Register");
		registrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into AccountInfo (username,password,email,accountType) values (?,?,?,?)";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, userTextField.getText());
					preparedStatement.setString(2, passTextField.getText());
					preparedStatement.setString(3, emailTextField.getText());
					preparedStatement.setString(4, accountTypeTextField.getText());
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "Account has been created!");
					preparedStatement.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		registrationButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		registrationButton.setBounds(177, 172, 89, 23);
		contentPane.add(registrationButton);
		
		JLabel message2Label = new JLabel("Already have an account?");
		message2Label.setHorizontalAlignment(SwingConstants.TRAILING);
		message2Label.setFont(new Font("Calibri", Font.PLAIN, 11));
		message2Label.setBounds(181, 236, 124, 14);
		contentPane.add(message2Label);
		
		JButton returnButton = new JButton("Return to Login");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				dispose();
				Application.main(null);
			}
		});
		returnButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		returnButton.setBounds(317, 232, 107, 23);
		contentPane.add(returnButton);
		
		JLabel message1Label = new JLabel("Create a new account today!");
		message1Label.setFont(new Font("Calibri", Font.BOLD, 12));
		message1Label.setBounds(151, 36, 146, 14);
		contentPane.add(message1Label);
	}
}
