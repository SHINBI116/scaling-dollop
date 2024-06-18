package quiz;

import java.util.Scanner;

public class B08_ChangeCase {
	/*
	 	사용자가 영어로 된 문장을 입력하면 대소문자를 반대로 바꿔서 출력해주는 프로그램을 만들어보세요
	 	
	 	입력> I Like To Try Apple
	 	출력> i lIKE tO tRY aPPLE

	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("영어 문장 입력 > ");
		String text = sc.nextLine();
		int len = text.length();
		int changeL = 0;
		int changeS = 0;

		for (int i = 0; i < len; ++i ) {
			char ch = text.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				changeL = ch - ' ';
				System.out.print((char) changeL);
			} else if ( ch >= 'A' && ch <= 'Z'){
				changeS = ch + ' ';
				System.out.print((char) changeS);
			} else {
				System.out.print(ch);
			}
			
		}
		
	}

}
