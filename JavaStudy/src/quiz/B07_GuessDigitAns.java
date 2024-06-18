package quiz;

import java.util.Scanner;

public class B07_GuessDigitAns {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		
		System.out.println( (int)(Math.log10(num)) + 1);
		
		
		
//		int cnt;
//		for (cnt = 0; num > 0; num /= 10) {
//			++cnt;
//		}
//		System.out.println(cnt + "자리 숫자입니다.");
		

		
//		2. 원시적 생각 잘 밀어붙인 결과
//		int cnt = 1;
//		for (int compare = 10; compare <= num; compare *= 10) {
//			++cnt;
//		}
//		System.out.println(cnt + "자리 입니다.");
//		1. 원시적생각
//		if (num<10) {
//			System.out.println("한자리");
//		} .........
		

	}

}
