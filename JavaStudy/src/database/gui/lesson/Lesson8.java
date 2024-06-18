package database.gui.lesson;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Lesson8 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Lesson 08");
		frame.setSize(640, 480);
		frame.setLocationRelativeTo(null);
		
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./image/bg_school_room2.jpg").getImage());	
		frame.add(panel);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
