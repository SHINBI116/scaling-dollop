package database.gui.lesson;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lesson9 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson9 window = new Lesson9();
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
	public Lesson9() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 965, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 927, 691);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btn = new JButton("");
		btn.setIcon(new ImageIcon("C:\\Users\\sinbe\\OneDrive\\문서\\ezen\\aiautomation_LSB\\JavaStudy\\myimage\\animals\\cat\\고양이.jpg"));
		btn.setSelectedIcon(new ImageIcon("C:\\Users\\sinbe\\OneDrive\\사진\\스크린샷\\스크린샷 2024-06-09 143951.jpg"));
		btn.setRolloverIcon(new ImageIcon("C:\\Users\\sinbe\\OneDrive\\문서\\ezen\\aiautomation_LSB\\JavaStudy\\myimage\\animals\\dog\\몸보신1.jpg"));		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn.setBounds(126, 59, 615, 568);
		panel.add(btn);
	}
}
