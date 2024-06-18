package quiz;

import java.util.Scanner;

public class B07_GuessDigit {

	/*
	 	(1) 사용자가 어떤 숫자를 int타입으로 입력하면 해당 숫자가 몇 자리 숫자인지
	 		알려주는 프로그램을 만들어보세요
	 	
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자입력 > ");
		int num = sc.nextInt();
		int abs_num = Math.abs(num);
		int cnt = 0;
		for (int count = 0; abs_num >=  0; abs_num /= 10) {
			++cnt;
		}
		System.out.println(cnt);
		
	}

}
