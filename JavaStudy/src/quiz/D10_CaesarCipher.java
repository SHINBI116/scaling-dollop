package quiz;

public class D10_CaesarCipher {
	/*
	 	# 시저(카이사르) 암호
	 	
	 	- 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 변경하여 암호문을 생성하는
	 	  암호 알고리즘
	 	  
	 	  [암호표]
	 	  ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789!@#$%^&*()-_=+
	 	  abcdefghijklmnopqrsuvwxyz {}[]|\;:'"/?<>,.
	 	  
	 	  * 암호화
	 	  (평문)		key : 3			(암호문)
	 	  HELLO! ---------------- > KHOOR!
	 	  
	 	  * 복호화
	 	  			key : 3
	 	  HELLO <-------------  KHOOR!
	 */
	
	/*
	 	1. 평문과 키 값이 전달되면 해당 평문을 암호문으로 변환하여 리턴해주는 메서드
	 	
	 	2. 암호문과 키 값이 전달되면 해당 암호문을 평문으로 변환하여 리턴해주는 메서드
	 	
	 	※ 암호화 할 수 있는 문자의 종류 : 영어 대문자, 영어 소문자, 숫자, 특수문자 
	 */
	
	final static String PASSWORD = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789!@#$%^&*()-_=+" +
						"abcdefghijklmnopqrsuvwxyz {}[]|\\;:'\"/?<>,.";
	
	final static int PASSWORD_LEN = PASSWORD.length();
	
	public static StringBuilder transCaesar(String normal_text, int key) {
		StringBuilder transCaesar = new StringBuilder(normal_text);
		
		while (key >= PASSWORD_LEN) {
			key -= PASSWORD_LEN;			
		}

		for (int i = 0; i < normal_text.length(); ++i) {
			for (int j = 0; j < PASSWORD_LEN; ++j) {
				if (transCaesar.charAt(i) == PASSWORD.charAt(j)) {
					if (j + key < PASSWORD_LEN) {
						transCaesar.setCharAt(i, PASSWORD.charAt(j + key));
					} else  {
						transCaesar.setCharAt(i, PASSWORD.charAt(j + key - PASSWORD_LEN));
					}
					break;
				}
			}
		}
		
		
		return transCaesar;
	}
	
	public static String transNormal (StringBuilder transCaesar, int key) {
		
		while (key >= PASSWORD_LEN) {
			key -= PASSWORD_LEN;
		}
			
		for (int i = 0; i < transCaesar.length(); ++i) {
			for (int j = 0; j < PASSWORD_LEN; ++j) {
				if (transCaesar.charAt(i) == PASSWORD.charAt(j)) {
					if (j - key >= 0) {
						transCaesar.setCharAt(i, PASSWORD.charAt(j - key));
					} else {
						transCaesar.setCharAt(i, PASSWORD.charAt(j - key + PASSWORD_LEN));
					}
					break;
				} 
			}
		
		}
		
		String normal_text = new String(transCaesar);
		return normal_text;
	}
	
	public static void main(String[] args) {
		String text = "Hello, world!!";
		int key = 13334;
		
		System.out.println(transCaesar(text, key));
		System.out.println(transNormal(transCaesar(text, key), key));
		
//		StringBuilder password = new StringBuilder(PASSWORD);
//		System.out.println(password.indexOf(","));
//		System.out.println(password.indexOf("<"));
	}
}
