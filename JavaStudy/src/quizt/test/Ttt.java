package quizt.test;

import java.util.Arrays;
import java.util.Scanner;

public class Ttt {	
	//1. 문자열을 전달하면 해당 문자열을 랜덤으로 뒤섞은 결과를 반환하는 함수
	
		//2. 문자열을 전달하면 해당 문자열을 거꾸로 뒤집은 문자열을 반환하는 함수
		
		//3. 문자열을 전달하면 해당 문자열의 좌우대칭 여부를 반환
		
		//4. 함수를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 함수
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(randomArr(0, 6, 5)));
		System.out.println(shuffle("가나다라 마"));
		System.out.println(reverse("가나가나가나"));
		getLottoNums();
	}
	
	public static int[] randomArr (int start, int end, int size) {
		int[] arr = new int[size];
		
		int currIndex = 0;
		while (currIndex < size) {
			int num = (int)(Math.random() * (end - start +1)  + start);
			
			boolean repeat = false;
			
			for (int i = 0; i < currIndex; ++i) {
				if (arr[i] == num) {
					repeat = true;
					break;
				}
			}
			
			if (!repeat) {
				arr[currIndex++] = num;
			}
		}
		
		return arr;
	}
	
	public static String shuffle(String text) {
		int len = text.length();
		int[] ranNum = randomArr (0, len - 1, len);
		String shuffleText = "";
		
		for (int i = 0; i < len; ++i) {
			shuffleText += text.charAt(ranNum[i]);
		}
		return shuffleText;
	}
	//2. 문자열을 전달하면 해당 문자열을 거꾸로 뒤집은 문자열을 반환하는 함수
	
	public static String reverse(String text) {
		String reverseText = "";
		int len = text.length();
		for (int i = len - 1; i >= 0; --i) {
			reverseText += text.charAt(i);
		}
		return reverseText;
	}
	
	//3. 문자열을 전달하면 해당 문자열의 좌우대칭 여부를 반환
	public static boolean isMirror (String text) {
		return text.equals(reverse(text)) ;
	}
	//4. 함수를 호출하면 1 ~ 45 사이의 중복없는 숫자 7개로 이루어진 배열을 반환하는 함수
	public static void getLottoNums () {
		System.out.println(Arrays.toString(randomArr(1, 45, 7)));
	}

}
