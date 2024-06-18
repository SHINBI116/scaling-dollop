package myobj.academy;
//네트워크 반 학생들은
//국어, 영어, 리눅스, 네트워크, CCNA 점수가 있다
public class NetworkStudent extends AcademyStudent {
	int kor;
	int eng;
	int linux;
	int network;
	int ccna;

	public NetworkStudent() {
		super();
		kor = generateRandomScore();
		eng = generateRandomScore();
		linux = generateRandomScore();
		network = generateRandomScore();
		ccna = generateRandomScore();
				
	}
	
	@Override
	public int getTotal() {
		return kor + eng + linux + network + ccna;
	}
	
	@Override
	public double getAvg() {
		return getTotal() / 5.0;
	}
	

	
	
	@Override
	public String getScores() {
		return String.format("국어: %d\n영어: %d\n리눅스: %d\n"
				+ "네트워크: %d\nCCNA: %d\n", kor, eng, linux, network, ccna);
	}
}
