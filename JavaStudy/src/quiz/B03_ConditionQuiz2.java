package quiz;

import java.util.Scanner;

public class B03_ConditionQuiz2 {
	
	public static void main(String[] args) {
		
		/*
		 	# 알맞은 조건식을 만들어보세요
		 	
		 	1. char형 변수 a가 'q' 또는 'Q' 일때 true
		 	2.char형 변수 b가 공백이나 탭이 아닐 때 true
		 	3.char형 변수 c가 '0'~'9'일때 true
		 	4.char형 변수 d가 영문자(대문자 또는 소문자)일때 true 
		 	5.char형 변수 e가 한글일 때 true(한글 범위 유니코드 검색)
		 	6.사용자가 입력한 문자열이 quit일 때 true
		 */
		
		//1.
		char a = 'q';
		System.out.println("1번: "+(a == 'q' || a == 'Q'));
		
		//2.
		char b ='\t';
		System.out.println("2번: "+ (b !=' ' && b != '\t') );
		
		//System.out.println( !(b=='\t' || b ==' ') );
		
		//3.
		char c ='0';
		System.out.println("3번: "+ (c>='0' && c<='9') );
		
		
		//4.
		char d= 'u';
		System.out.println("4번: "+ ( d>='A' && d<='Z' || d>='a' && d<='z') );
		
		
		//5.
		char e ='휉';
		System.out.println( ("5번: "+ ( (int)e>=44032 && (int)e<=55203) ) );
		//System.out.println(e>='가' && e<='힣');
		//16진수				     0xAC00    0xD7A3
		
		//6.
		Scanner sc =new Scanner(System.in);
		//or java.util.Scanner sc=~~;
		
		System.out.print("imput command > ");
		String cmd = sc.next();
		//문자열 비교는 ==로 하면 x
		//System.out.println(cmd == "quit");
		
		//문자열 비교는 equals()
		System.out.println("6번:"+cmd.equals("quit"));
		
		//대소문자 상관없이 같은 문자열인지 비교
		//System.out.println(cmd.equalsIgnoreCase("quit"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
