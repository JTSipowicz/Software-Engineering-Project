package CurrencyExchange;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.JSpinner;
import java.awt.Panel;
import javax.swing.JToolBar;

public class Application extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application frame = new Application();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Application() {
		setForeground(new Color(204, 0, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(567, 295, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(498, 300, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(485, 331, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnNewButton.setBounds(567, 357, 96, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(567, 409, 96, 24);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("Create an account!");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(443, 399, 114, 48);
		contentPane.add(lblNewLabel_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(567, 326, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Welcome to our Currency Exchange Application.");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewLabel.setBackground(new Color(255, 255, 224));
		lblNewLabel.setBounds(10, 2, 270, 20);
		contentPane.add(lblNewLabel);
		
//		JLabel lblNewLabel_4 = new JLabel("");
//		Image img = new ImageIcon(this.getClass().getResource("/CurrencyExchange/images/BackgroundImage.jpg")).getImage();
//		lblNewLabel_4.setIcon(new ImageIcon(img));
//		lblNewLabel_4.setBounds(20, 33, 400, 400);
//		contentPane.add(lblNewLabel_4);
		
		
		
	}
}
