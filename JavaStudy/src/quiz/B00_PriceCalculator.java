package quiz;

import java.util.Scanner;

public class B00_PriceCalculator {
	/*
	 	4가지 음료수 개수를 입력하면 총 가격을 출력
	 	(각 음료수의 가격은 2300,2800,3300,3500) 
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("음료수 개수 >> ");
		int drinks_num1 =sc.nextInt();
		int drinks_num2 =sc.nextInt();
		int drinks_num3 =sc.nextInt();
		int drinks_num4 =sc.nextInt();
		
		System.out.printf("1번:%d개,2번:%d개,3번:%d개,4번:%d개\n",drinks_num1,drinks_num2,drinks_num3,drinks_num4);
		
		//int num1_bill =2300, num2_bill = 2800, num3_bill= 3300, num4_bill =3500;
		int total=drinks_num1*2300+drinks_num2*2800+drinks_num3*3300+drinks_num4*3500;
		
		System.out.printf("총 금액은 : %d원",total);
		
		//ctrl + / : 블록지정 // 
		
		/*int qty1=sc.nextInt();
		  int qty2=sc.nextInt();
		  int qty3=sc.nextInt();
		  int qty4=sc.nextInt();
		  //블록 +alt 방향키:순서바꾸기
		  int price1=2300;
		  int price2=2800;
		  int price3=3300;
		  int price4=3500;
		  
		  System.out.printf("1번 음료 : %d원\n",price1);
		  System.out.printf("2번 음료 : %d원\n",price2);
		  System.out.printf("3번 음료 : %d원\n",price3);
		  System.out.printf("4번 음료 : %d원\n",price4);
		  System.out.printf(">");
		  
		  System.out.printf("첫 번째 음료:%d개\n",qty1);
		  System.out.printf("첫 번째 음료:%d개\n",qty2);
		  System.out.printf("첫 번째 음료:%d개\n",qty3);
		  System.out.printf("첫 번째 음료:%d개\n",qty4);
		  
		 // System.out.println(sc.nextInt()*2300+
		  sc.nextInt()*2800+sc.n
		*/
		
		/*int bill = 2300*drinks_num;
		
		System.out.printf("총 가격: %d원",bill);*/
		
		
		
		
		
	}
	
	
	
}
