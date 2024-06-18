package myobj.wheel;

import java.util.Arrays;
import java.util.LinkedList;

import myobj.RoulettePrize;

/*
	# 돌림판을 돌려서 경품을 추첨하는 프로그램을 만들어보세요.
	
	1. 경품들은 경품의 보유가치와 한정된 수량이 있다.
	
	2. 돌림판 인스턴스를 생성한 후 여러 종류의 경품을 추가할 수 있어야 한다
	   
	   돌림판 돌 = new 돌림판();
	   돌.add(경품);
	   돌.add(경품);
	
	3. 돌림판 인스턴스에 추가되어 있는 경품들의 당첨 확률을 수정할 수 있어야 한다.
	
	4. 만약 수량이 모두 소진된 상품에 걸린다면 돌림판을 다시 돌린다
	
*/
public class Wheel_EX {
	
	class Prize_Ex {
		String name;
		int price;
		int amount;
		int degree;
		
		public Prize_Ex(String name, int price, int amount, int degree) {
			this.name = name;
			this.price = price;
			this.amount = amount;
			this.degree = degree;
		}
		
		public void setDegree(int degree) {
			this.degree = degree;
		}
		
		public int minusAmount() {
			return --amount;
		}
		public int getDegree() {
			return degree;
		}
		
		@Override
		public String toString() {
			return String.format("%d원 가치의 %s\n", price, name);
		}

		
	}
	
	
	final static int[] WHEEL = new int[360];

	LinkedList<Prize_Ex> prizeList = new LinkedList<>();
	int index = 0;
	public Wheel_EX() {

	}
	
	public void add(RoulettePrize prize) {
		
	}
	
	private int totalDegree() {
		return 0;
	}
	
	public void modifyDegree(int index, int degree) {
		
		
	}
	
	private void update() {
		
	}
	
//	public RoulettePrize roll() {
//		return win[(int)(Math.random() * win.length)];
//
//	}
	
	public static void main(String[] args) {
		
	}
	
	
}
