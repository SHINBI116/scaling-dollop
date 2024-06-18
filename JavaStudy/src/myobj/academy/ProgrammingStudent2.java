package myobj.academy;
//1. 웹 프로그래밍 반 학생들은
// 국어, 영어, 수학, C언어, 운영체제, 자료구조 점수가 있다
public class ProgrammingStudent2 extends AcademyStudent {
	
	static String[] subjectName = {"국어", "영어", "수학", "C언어", "운영체제", "자료구조"};
	int[] subject = new int[6];
	
	public ProgrammingStudent2() {
		for (int i = 0; i < subject.length; ++i) {
			subject[i] = generateRandomScore();
		}
	}
	
	@Override
	public int getTotal() {
		int sum = 0;
		for (int i = 0; i < subject.length; ++i) {
			sum += subject[i];
		}
		return sum;
	}
	
	@Override
	public double getAvg() {
		return getTotal() / (double)subject.length;
	}
	
	@Override
	public String getScores() {
		String str = "";
		for (int i = 0; i < subject.length; ++i) {
			str += String.format("%s : %d\n", subjectName[i], subject[i]);
		}
		return str;
	}
}
