package quiz;

import java.util.Scanner;

public class B03_Square {
	/*
	 	※ 직사각형의 넓이를 계산하고 출력
	 	
	 	조건)
	 	문자열 변수로 직사각형 이름입력받기
	 	실수형 변수로 가로 세로 길이 입력
	 	이름과 넓이 출력하기(이름에 쌍따옴표 넣고 넓이는 소수점 2자리까지 출력)
	 	넓이가 100초과 500미만이라면 true
	 	
	 	예)
	 	이름 상민
	 	가로 10.5
	 	세로 10.5
	 	"상민" 직사각형의 넓이는 110.25
	 	true
	 */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("직사각형 이름: ");
		String name = sc.next();
		
		System.out.printf("가로 입력: ");
		double width = sc.nextDouble();
		
		System.out.printf("세로 입력: ");
		double height=sc.nextDouble();
		
		double square = width*height;
		
		// %.2f or Math.round(width*square*100)/100.0
		System.out.printf("\"%s\" 직사각형의 넓이는 %.2f\n",name,square);
		
		System.out.println(square>100 && square<500);
		
		/*
		 * 
		 * print("이름입략:);
		 String name =sc.next";
		 System.out.printf("가로 입력: ");
		 *double width = sc.nextDouble();
		 *System.out.printf("세로 입력: ");
		 *height=sc.nextDouble();
		 *double area =Math.round(width*square*100)/100.0
		 *System.out.printf("\"%s\" 직사각형의 넓이는 %.2f\n",name,area);
		 */
		
		
	}

}
