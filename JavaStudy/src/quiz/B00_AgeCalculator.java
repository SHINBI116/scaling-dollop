package quiz;

import java.util.Scanner;

public class B00_AgeCalculator {
	
	/*
	 	이름과 태어난 년도를 입력하면 이름과 나이를 출력해주는 프로그램을 만들어보세요
	 	
	 	ex> 김동우 1997
	 	
	 	김동우 (28세) 출력
	 */
	public static void main(String[] args ) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("이름입력: ");
		String name = sc.nextLine();
		
		
		System.out.print("출생년도 입력: ");
		int year = sc.nextInt();
		 
		int age = 2024-year+1;
		
		System.out.printf("%s(%d세)",name,age);
		
		
		
		/*System.out.print("이름과 출생년도 입력 > ");
		
		
		String name = sc.next();
		int year =sc.nextInt();
		
		//System.out.printf("이름%s 년도%d",name,age);
		
		int age = 2024-year+1;
		
		System.out.printf("%s(%d세)",name,age);
		*/
	
		
		
	}
	
	
	

}
