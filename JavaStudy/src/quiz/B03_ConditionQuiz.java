package quiz;

import java.util.Scanner;

public class B03_ConditionQuiz {
	
	/*
	 	#알맞은 비교연산을 만들기
	 	
	 	1. int 형 변수 a가 10보다 크고 20보다 작을 때 true
	 	2.int형 변수 b가 짝수일때 true
	 	3.int형 변수 c가 7의 배수일때 true
	 	4.int형 변수 d와 e의 차이가 30일때 true
	 	5.int형 변수 year가 400으로 나누어 떨어지거나 또는 4로 나누어 떨어지고 100으로 나누어 떨어지지 않을 때 true
	 	6.boolean형 변수 powerOn이 false일때 true
	 	7.문자열 참조변수 str이 "yes"일때 true
	 */
	
	public static void main(String[] args) {
		
		//1.
		int a=20;
		System.out.println("1번: "+  (a>10 && a<20 ));
		
		//2.
		int b =28 ;
		System.out.println("2번: "+(b%2 == 0));
		
		//3.
		int c =70;
		System.out.println("3번: "+(c%7==0));
		
		//4.
		int d= 33, e=63;
		System.out.println("4번: "+( d>e && d-e==30 || d<e && e-d == 30));
		//System.out.println(e-d == 30 || e-d == -30);
		//System.out.println(e-d == 30 || d-e == 30);
		//System.out.println(Math.abs(e-d) ==30);
		
		
		//5.
		//※윤년 계산하는 공식
		int year =2024;
		System.out.println("5번: "+(year%400==0 || year%4==0 && year%100!=0 ));
		
		//6.
		boolean powerOn =false;
		//boolean powerOff=!powerOn
		System.out.println("6번: "+(!powerOn));
		
		//7.
		// 기본형 타입들은 ==으로 같음을 나타낼 수 있지만
		// 참조형 변수들은 ==대신 .equals() 메서드를 사용해야한다
		System.out.print("yes or no? > ");
		String str = new Scanner(System.in).next();
		System.out.println("7번: "+ (str.equals("yes")) );
	
	}

}
