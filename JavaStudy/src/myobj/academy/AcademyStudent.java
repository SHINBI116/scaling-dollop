package myobj.academy;

public class AcademyStudent {
	
	private static NameGenerator nameGenerator = new NameGenerator();
	private static StunumGenerator stunumGenerator = new StunumGenerator("EZEN");
	static int stuCount = 1;
	
	// 인스턴스 변수에 직접 접근하는 것 보다는 getter를 생성하여 읽을 수 있게 해두는것이
	// 인스턴스 변수의 무분별한 수정을 막는 방법이다
	private String stuName;
	private String stuNum;

	
	protected AcademyStudent() {
		this.stuName = nameGenerator.generate();
		this.stuNum = stunumGenerator.generate();
	}
	
	public static void printDetail(AcademyStudent stu) {
		System.out.println("-------------------------");
		System.out.println("학번 : " + stu.stuNum);
		System.out.println("이름 : " + stu.stuName);
		System.out.println("-------------------------");
		System.out.println(stu.getScores());
		System.out.println("-------------------------");
		System.out.println("총점 : " + stu.getTotal());
		System.out.println("평균 : " + stu.getAvg());
		System.out.println("등급 : " + stu.getGrade());
		System.out.println("-------------------------");
	}
	
	protected static int generateRandomScore() {
		return (int)(Math.random() * 101 );
	}
	
	public String getStuName() {
		return this.stuName;
	}
	
	public String getStuNum() {
		return this.stuNum;
	}
	
	// 학생은 모두 공통적으로 과목별점수/총점/평균/등급을 알 수 있는 기능이 있다.
	// 하지만 세부적인 구현은 모두 달라야한다. -> 상속받아서 오버라이드 해서 쓰겠다
	public String getScores() {
		return null;
	}
	
	public int getTotal() {
		return -1;
	}
	
	public double getAvg() {
		return -1.0;
	}
	
	public String getGrade() {
		// 현재 인스턴스가 무엇인지에 따라 오버라이딩된 getAvg()가져다 사용한다
		double avg = getAvg();
		
		if (avg >= 90) {
			return "A";
		} else if (avg >= 80) {
			return "B";
		} else if (avg >= 70) {
			return "C";
		} else if (avg >= 60) {
			return "D";
		} else {
			return "F";
		}
	}
	
	
}
