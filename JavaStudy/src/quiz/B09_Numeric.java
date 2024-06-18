package quiz;

import java.util.Scanner;

/*
 	사용자가 입력한 문자열이 모두 숫자로만 구성된 문자열인지
 	판별해주는 프로그램을 만들어보세요
 */

public class B09_Numeric {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 > ");
		String text = sc.next();
		int len = text.length();
		boolean num_str = true;
		for (int i = 0; i < len; ++i) {
			char ch = text.charAt(i);
			if (!(ch >= '0' && ch <= '9')) {
				num_str = false;
				break;
			} 
		}
		if (num_str) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		
	}
}


