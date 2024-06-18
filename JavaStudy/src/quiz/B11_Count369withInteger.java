package quiz;

import java.util.Scanner;

public class B11_Count369withInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(">> ");
		int targetNum = sc.nextInt();
		int totalClapCount = 0;
		
		for (int i = 1; i <= targetNum; ++i) {
			System.out.print(i + ":\n");
			int num = i ;
			while (num > 0) {
				int digit = num % 10;
				System.out.print("\t" + digit + ": ");
				
				if (digit != 0 && digit % 3 == 0) {
					System.out.print("박수를 쳐야합니다!");
					++totalClapCount;
				}
				
				System.out.println();
				num /= 10;
				
			}
			
		}
			
			
			
//		for(int i = 1; i <= targetNum; ++i) {
//			// digit : 자릿수
//			long digit = 1;
//			while (digit <= 1000000000) {
//				// 한자릿수 분리
//				int num = (int)(i / digit % 10);
//				// 해당 자릿수 숫자가 0이 아니고 3의 배수이면 박수 횟수 증가
//				if (num != 0 && i / num % 3 == 0) {
//					++totalClapCount;
//				}
//				digit *= 10;
//			}
//			System.out.println("박수: " + totalClapCount);
			
//			//열의자리 체크
//			if (i / 1 % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
//				++totalClapCount;
//			}
//			// 십의 자리 체크
//			if (i / 10 % 10 == 3 || i / 10 % 10 == 6 || i / 10 % 10 == 9) {
//				++totalClapCount;
//			}
//			// 백의자리 체크
//			if (i / 100 % 10 == 3 || i / 100 % 10 == 6 || i / 100 % 10 == 9) {
//				++totalClapCount;
//			}
//		}

	}

}
