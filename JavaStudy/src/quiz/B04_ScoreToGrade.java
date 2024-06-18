package quiz;

import java.util.Scanner;

public class B04_ScoreToGrade {
	/*
	 * 국어,영어,수학 점수를 차례대로 입력받아 평균 점수를 구한 후에 평균 점수와 등급을 출력해준느 프로그램을 만들어보세요 (※각 과목의 유효
	 * 점수는 0~100점이고, 유효하지 않은 점수가 하나라도 있다면 평균점수는 0점 등급은 F로 나와야한다)
	  
	 * 1. 
	   평균점수 90점 이상 A 
	   평균점수 80점 이상 B 
	   평균점수 70점 이상 C 
	  			  그외 F
	  
	 */
	public static void main(String[] args) {

		int kor,eng,mat;
		double avg;
		char grade;
		
		boolean cheat=false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("국영수 성적입력: ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		
		
		if (kor < 0 || kor > 100) {
			System.out.println("국어성적오류");
			cheat = true;
		}
		if (eng < 0 || eng > 100) {
			System.out.println("영어성적오류");
			cheat = true;
		}
		if (mat < 0 || mat > 100) {
			System.out.println("수학성적오류");
			cheat = true;
		}
		
		
		if (cheat) {
			avg = 0;
		} else {
			avg = (kor + eng + mat) /3.0;
		}
		
		if (avg >= 90) {
			grade='A';
		} else if (avg >= 80) {
			grade='B';
		} else if (avg >= 70) {
			grade='C';
		} else {
			grade='F';
		}
		
		if (cheat) {
			System.out.printf("오류");
		}
		
		
		
		
		
		
//
//		System.out.println("국어 영어 수학 점수를 입력하세요. > ");
//		int kor = sc.nextInt();
//		int eng = sc.nextInt();
//		int mat = sc.nextInt();
//		double avg;
//		char rank;
//
//		if (!(kor >= 0 && kor <= 100) || !(eng >= 0 && eng <= 100) || !(mat >= 0 && mat <= 100)) {
//			System.out.println("[오류]유효하지 않은 점수가 있습니다.");
//			avg = 0;
//		} else {
//			avg = (kor + eng + mat) / 3.0;
//		}
//
//		// System.out.println(avg);
//
//		if (avg >= 90) {
//			rank = 'A';
//		} else if (avg >= 80) {
//			rank = 'B';
//		} else if (avg >= 70) {
//			rank = 'C';
//		} else {
//			rank = 'F';
//		}
//
//		System.out.printf("평균점수:%f점 등급:%c",avg, rank);
	

	}

}
