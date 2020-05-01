package CurrencyExchange;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 133, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Current Balance");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				AccountBalance.main(null);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton.setBounds(141, 69, 152, 92);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Make an Exchange");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Transaction.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_1.setBounds(141, 186, 152, 92);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Delete Your Account");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				DeleteAccount.main(null);
			}
		});
		btnNewButton_3.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_3.setBounds(376, 186, 152, 92);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Modify Account Info");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				ModifyAccount.main(null);
			}
		});
		btnNewButton_4.setFont(new Font("Calibri", Font.BOLD, 13));
		btnNewButton_4.setBounds(376, 69, 152, 92);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Log Out");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				Application.main(null);
			}
		});
		btnNewButton_6.setFont(new Font("Calibri", Font.PLAIN, 11));
		btnNewButton_6.setBounds(585, 427, 89, 23);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel_1 = new JLabel("In order for data to be saved, you must log out...");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setBounds(342, 431, 234, 14);
		contentPane.add(lblNewLabel_1);
	}
}
