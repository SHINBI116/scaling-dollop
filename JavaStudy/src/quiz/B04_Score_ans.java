package quiz;

import java.util.Scanner;

public class B04_Score_ans {

	public static void main(String[] args) {
		
		int kor,eng,math;//선언윗줄에먼저
		
		Scanner sc = new Scanner(System.in);//ctrl shift o :import 단축키
		
		System.out.printf("국영수 점수 입력 > ");
		kor =sc.nextInt();
		eng =sc.nextInt();
		math =sc.nextInt();
		
		//이상한 값이 있을 때 true로 변경할 예정인 변수
		boolean cheat =false;
		
		if (kor < 0 || kor > 100 ) {
			System.out.println("국어점수가 이상합니다!");
			cheat = true;
		} 
		if (eng < 0 || eng > 100){
			System.out.println("영어점수가 이상합니다!");
			cheat =  true;
		}
		if (math < 0 || math > 100) {
			System.out.println("수학점수가 이상합니다!");
			cheat = true;
		}
		
		double avg;
		char grade;
		//이상한 점수가 없으면 평균점수를 계산
		//이상한 점수가 있으면 그냥 점수를 넣음
		
		if (cheat) {
			avg=0;
			grade='F';
		} else {
			avg =(kor+eng+math)/3.0;//평균 점수를 구하기 위해 실수로 나눈다
			
			if (avg >=90) {
				grade = 'A';
			} else if (avg >=80 ) {
				grade='B';
			} else if (avg >=70) {
				grade='C';
			} else {
				grade='F';
			}
		}
		
		
		if (cheat) {
			System.out.println("잘못된 점수로 인해"+avg+"점 처리 되었습니다.");
			System.out.println("등급은 "+grade+"입니다.");
		} else {
			System.out.printf("평균 점수 '%.2f' 점으로 '%c'등급입니다.\n",avg,grade);
		}
		
		
		
		
		
		

	}

}
