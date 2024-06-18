package quiz;

import java.util.Arrays;

public class C00_FunctionQuiz_Ans {
	//1.
	public static boolean isAlphabet(char ch) {
		return (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z');
	}
	//2.
	public static boolean isMul3 (int num) {
		return num % 3 == 0;
	}
	//3.
	public static String checkEvenOdd (int num) {
		return num % 2 == 0 ? "짝수" : "홀수";
	}
	//4.
	public static int[] getYaksuList(int num) {
		int[] yaksuArr = new int[num];
		
		// num : 전달 받은 숫자
		// div : 전달 받은 숫자르 나눠볼 숫자
		int index = 0;
		for (int div = 1; div <= num; ++div) {
			if (num % div == 0) {
				// ++이 뒤에 들어갔으므로 대입을 하고 난 후 index가 증가한다
				yaksuArr[index++] = div;
			}
		}
		return Arrays.copyOf(yaksuArr, index);
	}
	//5.
	public static boolean isPrime(int num) {
		return getYaksuList(num).length == 2;
		
	}
	//6.
	public static void printMessage (String message, int times) {
		for (int i = 0; i < times; ++i) {
			System.out.println(message);
		}
	}
	public static void main(String[] args) {
		System.out.println(isAlphabet('L'));
		System.out.println(Arrays.toString(getYaksuList(13)));
		System.out.println(isPrime(8));
		
		printMessage(",", 10);
	}

}
