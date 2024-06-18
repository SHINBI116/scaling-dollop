package quiz;

import java.util.Arrays;

public class C00_FunctionQuiz {
	/*
	 	# 다음 함수를 정의하고 올바르게 동작하는지 테스트 해보세요
	 	
	 	1. 전달한 문자가 알파벳이면 true 아니면 false 반환하는 함수
	 	2. 전달한 숫자가 3의 배수이면 true 아니면 false
	 	3. 숫자를 하나 전달하면 문자열 "짝수입니다" 또는 "홀수입니다"
	 	4. 숫자를 전달하면 해당 숫자의 모든 약수를 int[]로 반환
	 	5. 전달한 정수가 소수라면 true를 반환 아니면 false
	 	6. 메시지와 횟수를 전달하면 해당 메세지를 전달한 횟수만큼 반복
	 */
	
	//1.
	public static boolean isAlphabet (char word) {
		return word >= 'a' && word <= 'z' || word >= 'A' && word <= 'Z' ? true : false;
	}
	
	//2.
	public static boolean isMultiple3 (int num) {
		return num % 3 == 0 ? true : false;
	}
	
	//3.
	public static String isEven (int num) {
		return num % 2 == 0 ? "짝수입니다" : "홀수입니다";
	}
	
	//4.
	public static String printDivisor (int num) {
		int cnt = 0;
		for (int i = 1; i <= num; ++i) {
			if (num % i == 0) {
				++cnt;
			}
		}
		int[] divisor = new int[cnt]; 
		cnt = 0;
		for (int i = 1; i <= num; ++i) {
			if (num % i == 0) {
				divisor[cnt] = i;
				++cnt;
			}
		}
		
		return Arrays.toString(divisor);
	}
	
	//5.
	public static boolean isPrime (int num) {
		if (num == 0 || num == 1) {
			return false;
		}
		int cnt = 0;
		int sqrt = (int) Math.sqrt(num);
		for (int i = 2; i <= sqrt; ++i) {
			if (num % i == 0) {
				++cnt;
				break;
			}
		}
		return cnt == 0 ? true : false;
	}
	
	//6. 
	public static void repeatMessage (String message, int repeat) {
		for (int i = 0; i < repeat; ++i) {
			System.out.println(message);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("문자는 알파벳? " + isAlphabet('B'));
		System.out.println("3의배수 ? " + isMultiple3(7));
		System.out.println("짝홀 ? " + isEven(44));
		System.out.println("약수 : " + printDivisor(22));
		System.out.println("소수 ? " + isPrime(3));
		repeatMessage("hello", 3);
		
	}

}
