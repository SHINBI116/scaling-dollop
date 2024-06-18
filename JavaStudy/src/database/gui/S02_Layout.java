package database.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class S02_Layout {
	/*
	 * # 레이아웃(Layout)
	 * 
	 * - 컨테이너에는 레이아웃을 설정할 수 있다 - 레이아웃은 해당 컨테이너에 컴포넌트를 배치하는 방식을 결정한다 - 컨테이너의 레이아웃을
	 * null로 설정하면 컴포넌트를 모두 직접 배치해야 한다
	 */
	public static void main(String[] args) {
		//new Border();
		// new GridLayoutExample();
		// new MyGridLayout();
		//new FlowLayoutExample();
		CardLayoutExample1 crdl = new CardLayoutExample1();

		// size is 300 * 300          
		crdl.setSize(300, 300);
		crdl.setVisible(true);
		crdl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class Border {
	JFrame f;

	Border() {
		// 프레임 인스턴스 생성
		// (JFrame으로 만든 인스턴스는 레이아웃 기본값이 BorderLayout이다)
		f = new JFrame();

		// 버튼 인스턴스 생성
		JButton b1 = new JButton("북쪽버튼");
		; // the button will be labeled as NORTH
		JButton b2 = new JButton("남쪽버튼");
		; // the button will be labeled as SOUTH
		JButton b3 = new JButton("동쪽버튼");
		; // the button will be labeled as EAST
		JButton b4 = new JButton("서쪽버튼");
		; // the button will be labeled as WEST
		JButton b5 = new JButton("중앙버튼");
		; // the button will be labeled as CENTER

		// 보더 레이아웃이 설정된 컨테이너에 컴포넌트를 붙일 때 방향을 설정 할 수 있다
		f.add(b1, BorderLayout.NORTH); // b1 will be placed in the North Direction
		f.add(b2, BorderLayout.SOUTH); // b2 will be placed in the South Direction
		f.add(b3, BorderLayout.EAST); // b2 will be placed in the East Direction
		f.add(b4, BorderLayout.WEST); // b2 will be placed in the West Direction
		f.add(b5, BorderLayout.CENTER); // b2 will be placed in the Center

		// 프레임의 기본 x버튼 동작이 눌렀을때 창을 사라지게 함 (DISPOSE_ON_CLOSE)
		// 프로그램이 제대로 종료되게 하려면 EXIT_ON_CLOSE로 변경해야함
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(100, 100);
		f.setSize(300, 300);
		f.setVisible(true);
	}
}

class GridLayoutExample {
	JFrame frameObj;

// constructor  
	GridLayoutExample() {
		frameObj = new JFrame();

		// creating 9 buttons
		JButton btn1 = new JButton("1");
		JButton btn2 = new JButton("2");
		JButton btn3 = new JButton("3");
		JButton btn4 = new JButton("4");
		JButton btn5 = new JButton("5");
		JButton btn6 = new JButton("6");
		JButton btn7 = new JButton("7");
		JButton btn8 = new JButton("8");
		JButton btn9 = new JButton("9");

		// adding buttons to the frame
		// since, we are using the parameterless constructor, therfore;
		// the number of columns is equal to the number of buttons we
		// are adding to the frame. The row count remains one.
		frameObj.add(btn1);
		frameObj.add(btn2);
		frameObj.add(btn3);
		frameObj.add(btn4);
		frameObj.add(btn5);
		frameObj.add(btn6);
		frameObj.add(btn7);
		frameObj.add(btn8);
		frameObj.add(btn9);

		// 보더 레이아웃이 아닌 다른 레이아웃은 컨테이너에 설정해줘야 한다
		// GridLayout은 행과 열을 지정할 수 있다
		frameObj.setLayout(new GridLayout(3, 3, 10, 20));

		frameObj.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frameObj.setLocation(400, 100);
		frameObj.setSize(300, 300);
		frameObj.setVisible(true);
	}
}

class MyGridLayout {
	JFrame f;

	MyGridLayout() {
		f = new JFrame();

		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");

		// adding buttons to the frame
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);

		// setting grid layout of 3 rows and 3 columns
		f.setLayout(new GridLayout(3, 3));
		f.setSize(300, 300);
		f.setVisible(true);
	}

}

class FlowLayoutExample {

	JFrame frameObj;

	// constructor
	FlowLayoutExample() {
		// creating a frame object
		frameObj = new JFrame();

		// creating the buttons
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton b10 = new JButton("10");

		// adding the buttons to frame
		frameObj.add(b1);
		frameObj.add(b2);
		frameObj.add(b3);
		frameObj.add(b4);
		frameObj.add(b5);
		frameObj.add(b6);
		frameObj.add(b7);
		frameObj.add(b8);
		frameObj.add(b9);
		frameObj.add(b10);

		// parameter less constructor is used
		// therefore, alignment is center
		// horizontal as well as the vertical gap is 5 units.
		frameObj.setLayout(new FlowLayout());

		frameObj.setLocation(700, 100);
		frameObj.setSize(300, 300);
		frameObj.setVisible(true);
	}

}

class GridBagLayoutDemo {
	final static boolean shouldFill = true;
	final static boolean shouldWeightX = true;
	final static boolean RIGHT_TO_LEFT = false;

	public static void addComponentsToPane(Container pane) {
		if (RIGHT_TO_LEFT) {
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		JButton button;
		pane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		if (shouldFill) {
//natural height, maximum width  
			c.fill = GridBagConstraints.HORIZONTAL;
		}

		button = new JButton("Button 1");
		if (shouldWeightX) {
			c.weightx = 0.5;
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Button 2");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Button 3");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		pane.add(button, c);

		button = new JButton("Long-Named Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40; // make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		pane.add(button, c);

		button = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // reset to default
		c.weighty = 1.0; // request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(10, 0, 0, 0); // top padding
		c.gridx = 1; // aligned with button 2
		c.gridwidth = 2; // 2 columns wide
		c.gridy = 2; // third row
		pane.add(button, c);
	}

	private static void createAndShowGUI() {
//Create and set up the window.  
		JFrame frame = new JFrame("GridBagLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Set up the content pane.  
		addComponentsToPane(frame.getContentPane());

//Display the window.  
		frame.pack();
		frame.setVisible(true);
	}

}

class CardLayoutExample1 extends JFrame implements ActionListener {

	CardLayout crd;

// button variables to hold the references of buttons  
	JButton btn1, btn2, btn3;
	Container cPane;

// constructor of the class  
	CardLayoutExample1() {

		cPane = getContentPane();

//default constructor used  
// therefore, components will   
// cover the whole area  
		crd = new CardLayout();

		cPane.setLayout(crd);

// creating the buttons  
		btn1 = new JButton("Apple");
		btn2 = new JButton("Boy");
		btn3 = new JButton("Cat");

// adding listeners to it  
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		cPane.add("a", btn1); // first card is the button btn1
		cPane.add("b", btn2); // first card is the button btn2
		cPane.add("c", btn3); // first card is the button btn3

	}

	public void actionPerformed(ActionEvent e) {
// Upon clicking the button, the next card of the container is shown  
// after the last card, again, the first card of the container is shown upon clicking  
		crd.next(cPane);
	}


}

