package database.gui.lesson;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Customer_App {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_App window = new Customer_App();
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
	public Customer_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(
				new ImageIcon("C:\\aiaumation_LSB\\JAVA_workspace\\JavaStudy\\myimages\\animals\\cats\\다운로드 (2).jpg").getImage());
		frame.setSize(welcomePanel.getWidth(), welcomePanel.getHeight());
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(1, 10, 353, 104);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		welcomePanel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setToolTipText("Enter ID");
		textField.setBounds(40, 50, 199, 55);
		welcomePanel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 20));
		passwordField.setBounds(60, 70, 199, 55);
		welcomePanel.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In Button");
		btnNewButton.setBounds(508, 357, 169, 79);
		welcomePanel.add(btnNewButton);
		
		frame.add(welcomePanel);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class ImagePanel extends JPanel {
	private Image img;
	
	public ImagePanel (Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() {
		return img.getWidth(null);
	}
	
	public int getHeight() {
		return img.getHeight(null);
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
	
}
