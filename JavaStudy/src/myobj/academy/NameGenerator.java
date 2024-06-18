package myobj.academy;

public class NameGenerator {
	// 다른 클래스에서 쓸 필요가 없는 자원들을 private으로 숨겨놓는다
	private String[] lastNameCandidates = {"김", "이", "박", "최"};
	private String[] firstNameCandidates = {"영", "철", "수", "지", "민", "식", "시", "은"};
	
	public void setLastNameCandidate(String ... lastNames) {
		this.lastNameCandidates = lastNames;
	}
	
	// 외부의 클래스에서 쓸 필요가 없는 기능들을 private 숨겨놓는다
	public void setfirstNameCandidate(String ... firstNameCandidates) {
		this.firstNameCandidates = firstNameCandidates;
	}
	
	private String selectRandomOne(String[] arr) {
		return arr[(int)(Math.random() * arr.length)];
	}
	
	public String generate() {
		return selectRandomOne(lastNameCandidates)
				+ selectRandomOne(firstNameCandidates)
				+ selectRandomOne(firstNameCandidates);
	}
	

}
