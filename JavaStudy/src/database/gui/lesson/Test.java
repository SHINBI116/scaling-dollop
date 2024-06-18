package database.gui.lesson;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ImagePanelE welcomePanel = new ImagePanelE(
				new ImageIcon("C:\\aiaumation_LSB\\JAVA_workspace\\JavaStudy\\myimages\\animals\\cats\\다운로드 (2).jpg").getImage());
		frame.setSize(800, 800);
		frame.getContentPane().add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setBounds(405, 166, 353, 104);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		welcomePanel.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setToolTipText("Enter ID");
		textField.setBounds(508, 198, 199, 55);
		welcomePanel.add(textField);
		textField.setColumns(10);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 20));
		passwordField.setBounds(508, 281, 199, 55);
		welcomePanel.add(passwordField);
		
		JButton btnNewButton = new JButton("Log In Button");
		btnNewButton.setBounds(508, 357, 169, 79);
		welcomePanel.add(btnNewButton);
		
		frame.add(welcomePanel);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ImagePanelE extends JPanel {
	private Image img;
	
	public ImagePanelE (Image img) {
		this.img = img;
		setSize(800, 800);
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