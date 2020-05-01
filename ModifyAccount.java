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

public class ModifyAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField passField;
	private JTextField emailField;
	private JTextField accountTypeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyAccount frame = new ModifyAccount();
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
	public ModifyAccount() {
		// Connection Statement
		connection = SQLiteConnection.databaseConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Modify Account Information");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 157, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 11));
		textField.setBounds(208, 53, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passField = new JTextField();
		passField.setFont(new Font("Calibri", Font.PLAIN, 11));
		passField.setBounds(208, 84, 96, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Calibri", Font.PLAIN, 11));
		emailField.setBounds(208, 115, 96, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		accountTypeField = new JTextField();
		accountTypeField.setFont(new Font("Calibri", Font.PLAIN, 11));
		accountTypeField.setBounds(208, 146, 96, 20);
		contentPane.add(accountTypeField);
		accountTypeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(139, 58, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(150, 89, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(150, 120, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Account Type :");
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(124, 149, 74, 14);
		contentPane.add(lblNewLabel_4);
		
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
		
		JLabel lblNewLabel_5 = new JLabel("Return to the Main Menu ");
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setBounds(208, 231, 119, 14);
		contentPane.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Modify Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query = "Update AccountInfo set username='" + textField.getText()+"'  ,password='" + passField.getText()+"'  ,email='" + emailField.getText()+"'  ,accountType='" + accountTypeField.getText()+"' where username='"+ textField.getText() + "'   ";
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null, "Data has been updated.");
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton_1.setBounds(208, 177, 96, 23);
		contentPane.add(btnNewButton_1);
	}

}
