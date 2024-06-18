package quiz;

import java.util.Scanner;

public class B08_PrintReverse {
	
	/*
	 	사용자가 어떤 문장을 입력하면 해당 문장을 거꾸로 출력해보세요.
	 */

	public static void main(String[] args) {
		
//		String text ="Apple";
//		
//		for (int i =0; i < 5; ++i) {
//			System.out.println(i);
//		}
//		System.out.println();
//		
//		for (int i = 0; i < 5; ++i) {
//			System.out.println(text.charAt(i));
//		}
//		System.out.println();
		
		// 마지막 인덱스부터 0까지 반복하며 한 글자씩 출력하기
		String text;
		Scanner sc = new Scanner(System.in);
		System.out.print("거꾸로 입력할 문장 입력 >> ");
		text = sc.nextLine();
		int len = text.length()-1;
		char ch;
		for (int i = len; i >= 0; --i ) {
			ch = text.charAt(i);
			System.out.print(ch);
		}
		
		// 마지막 인덱스에서 1씩 더 빼면서 한 글자씩 출력하기
		int len2 =text.length();
		for (int i =0; i < len; ++i) {
			System.out.print(text.charAt(len2 - i - 1));
		}
		System.out.println();

	}

}
