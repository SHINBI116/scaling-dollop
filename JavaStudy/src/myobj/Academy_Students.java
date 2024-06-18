package myobj;

import java.util.Arrays;

public class Academy_Students {
	String name = "";
	String studentClass;
	String academyNum = "";
	int[] subject = new int[6];
	public static int studentsLen = 100;
	Academy_Students[] student = new Academy_Students[studentsLen];
	
	static char[] lastName = {'김', '이', '박', '최'};
	static String[] selectClass = {"웹 프로그래밍", "네트워크", "머신러닝"};
	static String[] selectFirstName = {"철수", "영희", "길동", "지우", "나현", "유진", "병철"};
	
	public Academy_Students() {
		joinClass();
		ranScore();
		ranName();
	}
	
	public void joinClass() {
		int ranClass = (int)(Math.random() * selectClass.length);
		studentClass = selectClass[ranClass];
	}
	
	
	public String ranName() {
		int ranLastName = (int)(Math.random() * lastName.length);
		name += lastName[ranLastName];
		int ranFirstName = (int)(Math.random() * selectFirstName.length);
		name += selectFirstName[ranFirstName];
		
		return name;
	}
	
	public String ranAcademyNum() {
		int ran = (int)(Math.random() * 9999 ) + 1;
		academyNum += ran;
		return academyNum;
	}
	
	
	public void ranScore() {
		
		for (int i = 0; i < subject.length; ++i) {
			int ran = (int)(Math.random() * 81) + 20;
			subject[i] = ran;
		}
		
	}
	
	public int totalScore() {
		int sum = 0;
		for (int i = 0; i < subject.length; ++i) {
			sum += subject[i];
		}
		return sum;
	}
	
	public double avg() {
		double average = totalScore() / subject.length;
		
		return average;
	}
	
	public char grade() {
		if (avg() > 90) {
			return 'A';
		} else if (avg() > 80) {
			return 'B';
		} else if (avg() > 70) {
			return 'C';
		} else {
			return 'F';
		}
	}
	
	public void printStudentInfo() {
		System.out.println("학생이름: " + name);
		System.out.println("반: " + studentClass);
		System.out.println("과목별 점수: " + Arrays.toString(subject));
		System.out.println("총점: " + totalScore());
		System.out.println("평균: " + avg());
		System.out.println("등급: " + grade());
	}
	
	public void eachStudentClassInfo() {
		for (int i = 0; i < student.length; ++i) {
			Academy_Students currstudent = student[i];
			if (currstudent.studentClass.equals("웹 프로그래밍")) {
				currstudent = new Network();
				
			} else if (currstudent.studentClass.equals("네트워크")) {
				currstudent = new Web();
				
			} else if (currstudent.studentClass.equals("머신러닝")) {
				currstudent = new Machinerunning();
				
			}
		}
	}
	
	public static void main(String[] args) {
		Academy_Students st = new Academy_Students();
		st.printStudentInfo();
	}
	
}
