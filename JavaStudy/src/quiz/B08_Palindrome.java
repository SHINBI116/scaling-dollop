package quiz;

import java.util.Scanner;

public class B08_Palindrome {
	/*
	 	사용자가 단어를 입력하면 
	 	해당 단어가 좌우대칭을 이루는 단어인지 판별해주는 프로그램 만들기 (대소문자 구분x)
	 	
	 	>> LEVEL
	 	-> 좌우대칭입니다
	 	
	 	>>Apple
	 	-> 좌우대칭 x
	 	
	 	>>BOB
	 	-> 좌우대칭입니다  
	 	
	 	ABBA
	 	-> 좌우대칭
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단어 입력: ");
		String word = sc.next();
		word = word.toUpperCase();
		
		int len =word.length();
		int i;
		boolean mirror = true;
		for (i = 0; i < len; ++i) {
			if( word.charAt(i) == word.charAt(len-i-1) ) {
				mirror &= true;
			} else {
				mirror &= false;
			}
		}
		if (mirror) {
			System.out.println("좌우대칭");
		} else {
			System.out.println("좌우대칭아님");
		}
		
	
		

			
	}

}
