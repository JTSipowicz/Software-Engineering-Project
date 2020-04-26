package CurrencyExchange;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.TextField;
import java.awt.TextArea;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class App {

	private JFrame frame;

	private final JLabel label = DefaultComponentFactory.getInstance().createTitle("New JGoodies title");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Application Window Title
		frame = new JFrame("Currency Exchange");
		
		frame.getContentPane().setEnabled(false);
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(6);
		borderLayout.setHgap(400);
		frame.setBounds(200, 200, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Title Label
		JLabel lblNewLabel = new JLabel("Welcome to our Currency Exchange Application");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 15));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		// Submit Button
		JButton b = new JButton("Submit");
		b.setBounds(100,100,140, 40);
		
		// Name Label
		JLabel label = new JLabel();		
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText("Enter Name :");
		label.setBounds(10, 10, 100, 100);
		
		// Textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
		
		// Textfield to display entered name
		JLabel label1 = new JLabel();
		label1.setBounds(10, 110, 200, 100);
		
		frame.add(textfield);
		frame.add(label);
		frame.add(b); 
		frame.add(label1);


	}

}
