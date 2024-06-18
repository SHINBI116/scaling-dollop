package quiz;

import java.util.Scanner;

public class B08_CountE {
	/*
	 	사용자가 문장을 입력하면 해당 문장에 포함된 알파벳 e의 개수를 출력해보세요.
	 	(대/소문자 모두 개수에 포함)
	 */
	public static void main(String[] args) {
		String sentence;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("영어 문장을 입력해 주세요 > ");
		sentence = sc.nextLine();
		sentence = sentence.toUpperCase();
		
		int len = sentence.length();
		char wordE;
		int cnt = 0;
		
		for (int i = 0; i < len; ++i) {
			wordE = sentence.charAt(i);
			if (wordE == 'E') {
				++cnt;
			}
		}
		System.out.printf("e의 개수는 %d개",cnt);
		
	}

}
