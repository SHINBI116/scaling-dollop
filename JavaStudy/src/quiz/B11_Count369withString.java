package quiz;

import java.util.Scanner;

public class B11_Count369withString {
	
	/*
	 	사용자가 숫자를 입력하면
	 	해당 숫자까지 369가 진행됐을 때 박수를 총 몇 번 쳐야하는지 출력해보세요
	 	3 6 9 13 16 19 23 26 29 30 33(2번).. 36(2번) .. 333(3번)
	 	
	 	1. 숫자를 문자열로 취급하여 검사하는 방식
	 	
	 	2. 그냥 숫자로 검사하는 방식
	 	   %10 /10 
	 */

	public static void main(String[] args) {
		boolean DEBUG_MODE = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해보세요 >> ");
		int targetNum = sc.nextInt();
		int totalClapCount = 0;
		for (int i = 1; i <= targetNum; ++i) {
			if (DEBUG_MODE) {
			System.out.print(i + "\t: ");
			}
			String numStr = "" + i;
			int len = numStr.length();
			for (int index = 0; index < len; ++index) {
				char ch = numStr.charAt(index);
				if (ch == '3' || ch == '6' || ch == '9') {
					++totalClapCount;
					if (DEBUG_MODE) {
					System.out.print("짝");
					}
				}
			}
			if (DEBUG_MODE) {
			System.out.println();
			}
		}
		
		System.out.printf("%d번까지 369를 진행하면 박수를 총 %d번 쳐야합니다.\n", targetNum, totalClapCount);
		
		
	}
		
		
		



}
