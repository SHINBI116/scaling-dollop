package quiz;

import java.util.Random;

public class B12_TempPassword {
	/*
	 	알파벳 대문자로만 구성된 랜덤 4자리 비밀번호를 20개 생성하여 출력해보세요
	 	아스키 0 ~ 127
	 	65 ~ 90 0 ~ 26 
	 */
	public static void main(String[] args) {
		Random ran = new Random();

//		for(int i = 1; i <= 80; ++i) {
//			char word = (char) (ran.nextInt(26) + 'A');
//			System.out.print(word);
//			if (i % 4 == 0) {
//				System.out.println();
//			}
//		}
		
		for(int i = 1; i <= 20; ++i) {
			String passWord = "";
			for (int j = 1; j <= 4; ++j) {
				char word = (char) (ran.nextInt(26) + 'A');
				passWord += word;
			}
			System.out.println(passWord);
	
		}

	}

}
