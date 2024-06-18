package database.gui.lesson;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lesson6 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lesson6 window = new Lesson6();
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
	public Lesson6() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Lesson06");
		frame.setBounds(100, 100, 800, 600);
		//frame.setLocationRelativeTo(null);
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel endPage = new JPanel();
		endPage.setBounds(12, 10, 786, 563);
		frame.getContentPane().add(endPage);
		endPage.setLayout(null);
		
		JButton btnBefore = new JButton("GO TO LAST");
		btnBefore.setFont(new Font("궁서체", Font.BOLD, 40));
		btnBefore.setBounds(443, 10, 286, 375);
		endPage.add(btnBefore);
		
		JPanel startPage = new JPanel();
		startPage.setBounds(-31, 0, 805, 553);
		endPage.add(startPage);
		startPage.setLayout(null);
		
		JButton btnNext = new JButton("Go TO NEXT");
		btnNext.setBounds(72, 23, 238, 321);
		startPage.add(btnNext);
		
		frame.add(startPage);
		frame.add(endPage);
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				endPage.setVisible(true);
				startPage.setVisible(false);
				
			}
		});
		
		endPage.setVisible(false);
		
		btnBefore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				startPage.setVisible(true);
				endPage.setVisible(false);
				
			}
		});
	}
}
