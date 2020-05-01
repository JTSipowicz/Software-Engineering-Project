package CurrencyExchange;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteAccount extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount frame = new DeleteAccount();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Begin SQLite connection
	Connection connection = null;
	private JTextField textField;
	private JPasswordField passwordField;
	/**
	 * Create the frame.
	 */
	public DeleteAccount() {
		// Connection Statement
		connection = SQLiteConnection.databaseConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Deletion");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 113, 21);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 11));
		textField.setBounds(245, 72, 106, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 11));
		passwordField.setBounds(245, 103, 106, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(163, 75, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(187, 106, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Warning : Accounts can't be recovered!");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBounds(29, 186, 202, 38);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				MainMenu.main(null);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "delete from AccountInfo where username='" + textField.getText()+"'   ";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "Account Has Been Deleted");
					preparedStatement.close();
					contentPane.setVisible(false);
					dispose();
					Application.main(null);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton_1.setBounds(245, 134, 106, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Go back to the Main Menu :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(200, 231, 125, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Please re-enter your account credentials for security purposes. ");
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(124, 39, 281, 14);
		contentPane.add(lblNewLabel_5);
	}
}
