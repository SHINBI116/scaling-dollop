package myobj.academy;

public class ProgrammingStudent {
//	1. 웹 프로그래밍 반 학생들은
//	   국어, 영어, 수학, C언어, 운영체제, 자료구조 점수가 있다
	static String[] lastNameCandidates = {"김", "이", "박", "최"};
	static String[] firstNameCandidates = {"영", "철", "수", "지", "민", "식", "시", "은"};
	
	static int stuCount = 1;
	
	String stuName;
	String stuNum;
	int kor;
	int eng;
	int math;
	int c;
	int op; //operator
	int ds; // data structure
	
	public ProgrammingStudent() {
		this.kor = getRandomScore();
		this.eng = getRandomScore();
		this.math = getRandomScore();
		this.c = getRandomScore();
		this.op = getRandomScore();
		this.ds = getRandomScore();
		//String.format("format", values.... ) : 서식을 활용해 원하는 문자열을 생성하는 메서드
		this.stuNum = String.format("EZEN%06d", stuCount++);
		this.stuName = getRandomName();
		
	}
	
	public static int getRandomScore() {
		return (int)(Math.random() * 101);
	}
	
	public static String selectRandomOne(String[] arr) {
		return arr[(int)(Math.random() * arr.length)];
	}
	
	public static String getRandomName2() {
		return selectRandomOne(lastNameCandidates)
				+ selectRandomOne(firstNameCandidates)
				+ selectRandomOne(firstNameCandidates);
	}
	
	public static String getRandomName() {
		return lastNameCandidates[(int)(Math.random() * lastNameCandidates.length)]
				+ firstNameCandidates[(int)(Math.random() * firstNameCandidates.length)]
				+ firstNameCandidates[(int)(Math.random() * firstNameCandidates.length)];
				
	}
	
	// static이 없으면  현재 인스턴스(this)를 활용해 프린트 할 수 있다
	// static이 있으면 현재 인스턴스를 활용할 수 없는 대신 매개변스로 인스턴스를 전달받아 프린트 할 수 있다
	//  성적표 출력 메서드를 통해 각 학생의 [학번/이름/과목별점수/총점/평균/등급]을 볼 수 있다
	public static void printDetail(ProgrammingStudent stu) {
		System.out.println("-------------------------");
		System.out.println("학번 : " + stu.stuNum);
		System.out.println("이름 : " + stu.stuName);
		System.out.println("-------------------------");
		System.out.println("국어 : " + stu.kor);
		System.out.println("영어 : " + stu.eng);
		System.out.println("수학 : " + stu.math);
		System.out.println("C언어 : " + stu.c);
		System.out.println("운영체제 : " + stu.op);
		System.out.println("자료구조 : " + stu.ds);
		System.out.println("-------------------------");
	}
	
	@Override
		public String toString() {
			return String.format("%s\t/%s", stuNum, stuName);
		}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; ++i) {
			ProgrammingStudent stu = new ProgrammingStudent();
			ProgrammingStudent.printDetail(stu);
		}
	}
}
