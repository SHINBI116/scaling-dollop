package quiz;

import java.util.Arrays;

public class C00_FunctionQuiz2 {
	
	//1. 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 함수
	
	//2. 문자열을 전달하면 해당 문자열을 거꾸로 뒤집은 문자열을 반환하는 함수
	
	//3. 문자열을 전달하면 해당 문자열의 좌우대칭 여부를 반환
	
	//4. 함수를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 함수

	//1.
	public static String ranStr (String text) {
		char[] str = new char[text.length()];
		for (int i = 0; i < text.length(); ++i) {
			str[i] = text.charAt(i);
		}
		
		for (int i = 0; i < 1000; ++i) {
			int ran = (int)(Math.random() * text.length());
			char temp = str[0];
			str[0] = str[ran];
			str[ran] = temp;
		}
//		String strShuffle = "";
//		for (int i = 0; i < str.length; ++i) {
//			strShuffle += str[i];
//		}
		String strShuffle = new String(str);
		
		return strShuffle;
	}
	
	//2.
	public static String reverseText (String text) {
		String reverse = "";
		int len = text.length();
		for (int i = len - 1; i >= 0; --i) {
			reverse += text.charAt(i);
		}
		return reverse;
	}
	
	//3. 문자열을 전달하면 해당 문자열의 좌우대칭 여부를 반환
	public static boolean isMirror (String text) {
		String textL = text.toUpperCase();
		int len = text.length();
		int halfLen = len / 2;
		boolean mirror = true;
		for (int i = 0; i < halfLen; ++i) {
			char ch1 = textL.charAt(i);
			char ch2 = textL.charAt(len - i - 1);
			if (ch1 == ch2) {
				mirror = true;
			} else {
				mirror = false;
				break;
			}
		}
		return mirror;
	}
	
	//4. 함수를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 함수
	
	public static int[] lottoNum () {
		int[] lotto = new int [7];
		for (int i = 0; i < 7; ++i) {
			int ran = (int)(Math.random() * 45) + 1;
			lotto[i] = ran;
			for (int j = 0; j < i; ++j) {
				if (lotto[i] == lotto[j]) {
					--i;
					break;
				}
			}
		}
		return lotto;
	}
	
	public static void main(String[] args) {
		
		System.out.println(ranStr("Array text"));
		System.out.println(reverseText("elementary School"));
		System.out.println(isMirror("Aab0BAA"));
		System.out.println(Arrays.toString(lottoNum()));
	}

}
