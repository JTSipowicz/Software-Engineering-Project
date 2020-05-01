package CurrencyExchange;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transaction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	String[] messageStrings1 = {"Dollar ($)", "Euro (€)", "Yen (¥)"};
	String[] messageStrings2 = {"Dollar ($)", "Euro (€)", "Yen (¥)"};
	// Conversion Amount 
	String conversionAmountString;
	double conversionAmountDouble;
	// Current Account Balance Doubles
	double currentBalanceDollar;
	double currentBalanceEuro;
	double currentBalanceYen;
	// Updated Account Balances from making a transaction, with exchange fee! :)
	double updatedAccountBalanceDollar = (currentBalanceDollar - conversionAmountDouble) - 10;
	double updatedAccountBalanceEuro = (currentBalanceEuro - conversionAmountDouble) - 9.13;
	double updatedAccountBalanceYen = (currentBalanceYen - conversionAmountDouble) - 1072;
	
	// New Account Balances with corresponding currency exchange math
	double newBalanceDollarToEuro = conversionAmountDouble * 0.91;
	double newBalanceDollarToYen = conversionAmountDouble * 107;
	double newBalanceEuroToDollar = conversionAmountDouble * 1.09;
	double newBalanceEuroToYen = conversionAmountDouble * 117.15;
	double newBalanceYenToDollar = conversionAmountDouble * 0.0093;
	double newBalanceYenToEuro = conversionAmountDouble * 0.0085;
	
	//Message Selectors
	int messageSelector1;
	int messageSelector2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Begin SQLite connection
	Connection connection = null;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Transaction() {
		// Connection Statement
		connection = SQLiteConnection.databaseConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transaction Page");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 101, 14);
		contentPane.add(lblNewLabel);
		
		
		JComboBox comboBox = new JComboBox(messageStrings1);
		comboBox.setSelectedIndex(1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox) {
					JComboBox cb = (JComboBox)e.getSource();
					String message1 = (String)cb.getSelectedItem();
					if(message1 == "Dollar ($)") {
						messageSelector1 = 1;
					}else if(message1 == "Euro (€)") {
						messageSelector1 = 2;
					}else if(message1 == "Yen (¥)") {
						messageSelector1 = 3;
					}else{
						JOptionPane.showMessageDialog(null, "ComboBox 1 Error");
					}
				}
			}
		});
		comboBox.setFont(new Font("Calibri", Font.PLAIN, 11));
		comboBox.setBounds(98, 111, 69, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(messageStrings2);
		comboBox_1.setSelectedIndex(1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox_1) {
					JComboBox cb = (JComboBox)e.getSource();
					String message2 = (String)cb.getSelectedItem();
					if(message2 == "Dollar ($)") {
						messageSelector2 = 1;
					}else if(message2 == "Euro (€)") {
						messageSelector2 = 2;
					}else if(message2 == "Yen (¥)") {
						messageSelector2 = 3;
					}else {
						JOptionPane.showMessageDialog(null, "ComboBox2 Error");
					}
				}
			}
		});
		comboBox_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		comboBox_1.setBounds(258, 111, 69, 22);
		contentPane.add(comboBox_1);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Return to the Main Menu :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(196, 231, 131, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Make Transaction");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(messageSelector1 == messageSelector2) {
						JOptionPane.showMessageDialog(null, "Can't Transfer the same currency!");
					}else if(messageSelector1 == 1 && messageSelector2 == 2) {
						String query = "Update AccountInfo set Dollar='" + updatedAccountBalanceDollar+"'   ,Euro='" + newBalanceDollarToEuro+ "' where username='" + textField.getText()+ "'  ";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Exchange from Dollars to Euro Successful");
					}else if(messageSelector1 == 1 && messageSelector2 == 3) {
						String query = "Update AccountInfo set Dollar='" + updatedAccountBalanceDollar+"'   ,Yen='" + newBalanceDollarToYen+ "' where username='" + textField.getText()+ "'  ";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Exchange from Dollars to Yen Successful");
					}else if(messageSelector1 == 2 && messageSelector2 == 1) {
						String query = "Update AccountInfo set Euro='" + updatedAccountBalanceEuro+"'   ,Dollar='" + newBalanceEuroToDollar+ "' where username='" + textField.getText()+ "'  ";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Exchange from Euro to Dollar Successful");
					}else if(messageSelector1 == 2 && messageSelector2 == 3) {
						String query = "Update AccountInfo set Euro='" + updatedAccountBalanceEuro +"'   ,Yen='" + newBalanceEuroToYen+ "' where username='" + textField.getText()+ "'  ";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Exchange from Euro to Dollar Successful");
					}else if(messageSelector1 == 3 && messageSelector2 == 1) {
						String query = "Update AccountInfo set Yen='" + updatedAccountBalanceYen +"'   ,Dollar='" + newBalanceYenToDollar+ "' where username='" + textField.getText()+ "'  ";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Exchange from Yen to Dollar Successful");
					}else if(messageSelector1 == 3 && messageSelector2 == 2) {
						String query = "Update AccountInfo set Yen='" + updatedAccountBalanceYen +"'   ,Euro='" + newBalanceYenToEuro+ "' where username='" + textField.getText()+ "'  ";
						PreparedStatement preparedStatement = connection.prepareStatement(query);
						preparedStatement.execute();
						JOptionPane.showMessageDialog(null, "Exchange from Yen to Euro Successful");
					}else {
					JOptionPane.showMessageDialog(null, "Currency Selection Interaction Error");
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton_1.setBounds(170, 182, 122, 23);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 11));
		textField.setBounds(196, 56, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(124, 59, 62, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("convert to :");
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(186, 115, 62, 14);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conversionAmountString = textField_1.getText();
				conversionAmountDouble = new Double(conversionAmountString).doubleValue();
			}
		});
		textField_1.setBounds(219, 152, 108, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Amount for Conversion :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setFont(new Font("Calibri", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(98, 157, 111, 14);
		contentPane.add(lblNewLabel_4);
	}
}
