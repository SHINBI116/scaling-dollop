package example;

// 자식 클래스는 반드시 부모 클래스의 생성자를 먼저 호출해야한다
public class RedOrange extends Orange {
	
	// 다른 생성자가 없다면 생략 가능한 형태
	public RedOrange() {
		super();
	}
	
	public RedOrange(int price) {
		super(price, 10);
	}
}
