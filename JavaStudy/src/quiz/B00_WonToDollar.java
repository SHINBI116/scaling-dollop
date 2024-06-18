package quiz;

import java.util.Scanner;

public class B00_WonToDollar {
	
	/*
	 	한국 돈을 입력하면 달러로 얼마인지 출력해주는 프로그램 만들기
	 	(환율 검색,달러는 소수점둘째자리까지)
	 */
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		System.out.print("원화입력 > ");
		int won = sc.nextInt();
		//System.out.println(won);
		double dollar;
		
		dollar= won/1374.85;
		
		System.out.printf("%d원은 %.2f달러입니다",won,dollar);
		
		
		/*
		 scanner,println(),printf()
		 Scanner sc = new Scanner(System.in);
		 
		 System.out.print("KRW >> ");
		 int krw =sc.nextInt();
		 
		 //1달러당 1377.55원
		 double exchangRate =1377.55;
		 double usd = krw / exchangeRate;
		 
		 System.out.printf("%dKRW은 %.2fUSD입니다",krw,usd);
		 
		 */

	
	}
}
