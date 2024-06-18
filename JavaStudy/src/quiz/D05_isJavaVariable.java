package quiz;

import java.util.Scanner;

public class D05_isJavaVariable {
	/*
	 	사용자로부터 문자열을 입력받으면
	 	해당 문자열이 자바의 변수로 사용할 수 있는 문자열인지 검사해보세요
	 */
	
	
	
	public static boolean isJavaVariable(String userStr) {
		int len = userStr.length();
		
		if (!Character.isJavaIdentifierStart(userStr.charAt(0))) {
			return false;
		}
		for (int i = 0; i < len; ++i) {
			char ch = userStr.charAt(i);
			if (!Character.isJavaIdentifierPart(ch)) {
				return false;
			} 
		}	
		return true;
	}		
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열 입력 > ");
		boolean isJava = isJavaVariable(sc.nextLine());
		sc.close();
		
		if (isJava) {
			System.out.println("변수 사용가능");
		} else {
			System.out.println("변수 사용 불가능");
		}

	}
}
