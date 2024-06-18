package quiz;

public class B08_PalindromeAns {

	public static void main(String[] args) {
		
		// 원래 단어와 거꾸로 뒤집은 단어가 같으면 좌우대칭
		String word = "MOM";
		
		String reversed = "";
		int len = word.length();
		for (int i = 0; i < len; ++i) {
			//System.out.printf("%c",word.charAt(len-1-i));
			reversed += word.charAt(len - 1 -i);
		}
		
		System.out.println("좌우대칭입니까? " + reversed.equals(word));
		
		
		
		
		
		
		
		
//		String word = "ABBA";
//		
//		int len = word.length();
//		int half = len / 2 ;
//		
//		boolean isPalindrome = true;
//		
//		for ( int i = 0; i < half; ++i) {
//			//System.out.printf("%c vs %c\n",word.charAt(i),word.charAt(len-1-i));
//			
//
//		
//		
//		
//			char ch1 = word.charAt(i);
//			char ch2 = word.charAt(len - i - 1);
//			
//			if (ch1 != ch2) {
//				isPalindrome = false;
//			} 
//			}
//		if (isPalindrome) {
//			System.out.println("\"" + word + "\"" + "는 좌우대칭");
//		} else {
//			System.out.println("\"" +word + "\"" + "는 좌우대칭이 아닙니다");
//		}
//		
		}

	}


