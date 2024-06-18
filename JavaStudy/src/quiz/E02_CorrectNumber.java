package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E02_CorrectNumber {
	/*
	 	예외처리 방식을 사용하여 다음을 구현하세요
	 	
	 	1. 사용자가 중복없는 4개의 숫자를 한 글자씩 입력해야 한다
	 	
	 	2. 사용자가 입력한 숫자가 0 ~ 9 사이의 숫자가 아닌경우 예외가 발생해야 한다
	 	
	 	3. 사용자가 입력한 숫자가 이미 입력했던 숫자인 경우 예외가 발생해야 한다
	 	
	 	4. 숫자 4개를 모두 입력하고 나면 입력했던 숫자를 다시한번에 하나씩 입력하여 확인해야한다
	 	
	 	5. 사용자가 입력했던 숫자와 이번에 입력한 숫자가 다르다면 예외가 발생해야 한다
	 		 	 
	*/
	
	public static void inputNum(int[] num) throws NotDigit, AlreadyInputDigit {
		for (int i = 0; i < num.length; ++i) {
			if (num[i] < 0 || num[i] > 9) {
				throw new NotDigit();
			}
			for (int j = 0; j < i; ++j) {
				if (num[j] == num[i]) {
					throw new AlreadyInputDigit();
				}
			}
		}
		
		
		
	}
	
	public static void checkNum(int[] num1, int[] num2) throws NotEqualNum {
		Arrays.sort(num1);
		Arrays.sort(num2);
		for (int i = 0; i < num1.length; ++i) {
			if (num1[i] != num2[i]) {
				throw new NotEqualNum();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] userNum = {0, 0, 0, 0};
		
		
		
		while (true) {
			System.out.println("숫자 입력 > ");
			for (int i = 0; i < userNum.length; ++i) {
				userNum[i] = sc.nextInt();
			}
			
			
			try {
				inputNum(userNum);
				break;
			} catch (NotDigit e) {
				System.out.println("0 ~ 9 사이가 아닌 수가 포함되어 있습니다.");
				String trash = sc.nextLine();
				continue;
			} catch (AlreadyInputDigit e) {
				System.out.println("이미 입력된 수가 포함되어있습니다.");
				String trash = sc.nextLine();
				continue;
			}
		}
		int[] againUserNum = new int[4];
		
		
		
		while (true) {
			System.out.println("숫자 다시 한입력 > ");
			for (int i = 0; i < againUserNum.length; ++i) {
				againUserNum[i] = sc.nextInt();
			}
			try {
				checkNum(userNum, againUserNum);
				break;
			} catch (NotEqualNum e) {
				System.out.println("이전에 입력했던 숫자와 다릅니다");
				String trash = sc.nextLine();
				continue;
			}
		}
	}
}

class NotDigit extends Exception {
	public NotDigit() {
		super();
	}
}

class AlreadyInputDigit extends Exception {
	public AlreadyInputDigit() {
		super("이미 입력된 숫자입니다.");
	}
}

class NotEqualNum extends Exception {
	public NotEqualNum() {
		super();
	}
}