package myobj;

public class Book {
	public int page;
	public int total_page;
	
	// 인스턴스가 생성될 때 실행되는 곳
	// public : 다른 패키지에서 사용할 수 있게 만들어주는 키워드
	public Book() {
		System.out.println("새로운 인스턴스가 생성되었습니다!");
	}
	
	public void print() {
		System.out.println("Book 클래스에서 만든 print()입니다.");
	}
}
