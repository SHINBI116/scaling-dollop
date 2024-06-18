package quiz;

public class B12_TempPassword2 {
	/*
	 	대문자, 소문자, 특수문자, 숫자로 구성된
	 	6자리 랜덤 비밀번호를 20개 생성하여 출력하는 프로그램
	 	※ 비밀번호로 사용 가능한 특수문자의 아스키코드 범위 33 ~ 47 
	 */
	/*	
	 	대문자 : 65 ~ 90 0 ~ 26
	 	소문자 : 97 ~ 122 0 ~ 25
	 	숫자	 : 48 ~ 57 0 ~ 9
	 	특수	 : 33 ~ 47 0 ~ 14
	 	
	 	33 ~ 122 -> 0 ~ 89
	 	58 ~ 64 91~ 96 x
	 	
	 */
	public static void main(String[] args) {

		for (int i = 1; i <= 20; ++i) {
			System.out.printf("%2d번째 랜덤 비밀번호: ",i);
			String password = "";
			for (int j = 0; j < 6; ++j) {
				char word = (char)(Math.random() * 90 + 33);
				if (word >= 58 && word <= 64 || word >= 91 && word <= '`') {
					--j;
					continue;
				}
				password += word;
			}
			System.out.println(password);
		}

		
		
	}
	
}
