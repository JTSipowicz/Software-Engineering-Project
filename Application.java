package CurrencyExchange;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Application {
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField userField;
	private JPasswordField passField;
	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
		// Begin SQLite connection
		connection = SQLiteConnection.databaseConnection();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(150, 150, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		userField = new JTextField();
		userField.setFont(new Font("Calibri", Font.PLAIN, 11));
		userField.setBounds(577, 319, 100, 20);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		JButton signInButton = new JButton("Sign In");
		signInButton.addActionListener(new ActionListener() {
			// SQL query expression
			public void actionPerformed(ActionEvent arg0) {
				String query = "select * from AccountInfo where username=? and password=?";
				try {
					PreparedStatement preparedStatement = connection.prepareStatement(query);
					preparedStatement.setString(1, userField.getText().toLowerCase());
					preparedStatement.setString(2, passField.getText());
					//Result Sets
					ResultSet resultSet = preparedStatement.executeQuery();
					int count = 0;
					while(resultSet.next()) {
						count = count + 1;
					}
					if(count == 1) {
						JOptionPane.showMessageDialog(null, "Username and password is correct");
						frame.dispose();
						MainMenu mainMenu = new MainMenu();
						mainMenu.setVisible(true);
					} else if(count > 1) {
						JOptionPane.showMessageDialog(null, "Duplicate Username and password");
					} else {
						JOptionPane.showMessageDialog(null, "Username and password are invalid, try again!");
					}
					// SQL only provides one connection at a time
					resultSet.close();
					preparedStatement.close();
				}catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex);
				}
			}
		}); 
		signInButton.setFont(new Font("Calibri", Font.BOLD, 11));
		signInButton.setBounds(578, 381, 100, 20);
		frame.getContentPane().add(signInButton);
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Registration registration = new Registration();
				registration.setVisible(true);
			}
		});
		registerButton.setFont(new Font("Calibri", Font.BOLD, 11));
		registerButton.setBounds(578, 427, 100, 20);
		frame.getContentPane().add(registerButton);
		
		JLabel welcomeLabel = new JLabel("Welcome to our Currency Exchange Application");
		welcomeLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		welcomeLabel.setBounds(10, 11, 286, 14);
		frame.getContentPane().add(welcomeLabel);
		
		JLabel authorLabel = new JLabel("James Sipowicz, Mason Watson, Tyler Hanson, Jafeth Zuniga");
		authorLabel.setForeground(new Color(0, 0, 139));
		authorLabel.setFont(new Font("Calibri", Font.PLAIN, 10));
		authorLabel.setBounds(10, 436, 253, 14);
		frame.getContentPane().add(authorLabel);
		
		JLabel createAccountLabel = new JLabel("Create an account");
		createAccountLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		createAccountLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		createAccountLabel.setBounds(466, 430, 102, 14);
		frame.getContentPane().add(createAccountLabel);
		
		JLabel userLabel = new JLabel("Username :");
		userLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		userLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		userLabel.setBounds(505, 322, 62, 14);
		frame.getContentPane().add(userLabel);
		
		JLabel passLabel = new JLabel("Password :");
		passLabel.setFont(new Font("Calibri", Font.PLAIN, 11));
		passLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		passLabel.setBounds(505, 353, 62, 14);
		frame.getContentPane().add(passLabel);
		
		passField = new JPasswordField();
		passField.setFont(new Font("Calibri", Font.PLAIN, 11));
		passField.setBounds(577, 348, 100, 20);
		frame.getContentPane().add(passField);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("/CurrencyIcon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(63, 51, 350, 350);
		frame.getContentPane().add(lblNewLabel);
	}
}
