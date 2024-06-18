import myobj.Language_patch;

public class C04_Static {
	/*
	 	# static (정적 영역, 클래스 영역 <=> 인스턴스 영역)
	 	
	 	- 인스턴스 영역의 반대 개념
	 	- 같은 클래스로 만들어진 모든 인스턴스들이 함께 사용하는 공동 영역
	 	- 앞에 static이 붙은 자원들은 모든 인스턴스들이 함께 사용하는 공동의 자원이 된다
	 	- static 영역의 자원은 인스턴스 이름이 아닌 클래스이름으로 접근이 가능
	 	- 스태틱 영역은 인스턴스가 하나도 생생되지 않은 시점에도 존재한다
	 	 (최초로 해당 클래스가 호출되었을 때 생성된다)
	 	- 스태틱 영역의 값은 인스턴스 영역에 활용할 수 있지만
	 	  인스턴스 영역의 값은 스태틱 영역에 활용할 수 없다
	 	  
	 	# static을 붙일 수 있는 자원
	 	
	 	- 스태틱 변수 (모든 인스턴스에서 항상 같은 값을 가지는 공동의 변수)
	 	- 스태틱 매서드 (인스턴스가 존재하지 않을 때도 동작할 수 있는 메서드)
	 	- 클래스 내부의 스태틱 클래스 (?)
	 */
	public static void main(String[] args) {
		// 인스턴스를 하나도 생성하지 않은 시점에도 static 자원을 활용할 수 있다
		System.out.println(TrumpCard.card_width);
		System.out.println(TrumpCard.card_height);
		
		TrumpCard spade_a = new TrumpCard(0, 0);
		TrumpCard spade_2 = new TrumpCard(1, 0);
		TrumpCard heart_10 = new TrumpCard(9, 1);
		
		spade_a.card_width = 5000;
		
		System.out.println("스페이드A의 너비 : " + spade_a.card_width);
		System.out.println("스페이드2의 너비 : " + spade_2.card_width);
		System.out.println("하트10의 너비: " + heart_10.card_width);
		
		Language_patch lp = new Language_patch();
		lp.change_language("English");
		lp.startMessage();
		
	}

}

class TrumpCard {
	// 카드의 모양과 랭크는 모든 인스턴스에서 달라야 하는 값이다
	int rank; // A ~ K
	int suit; // 하트 1 스페이드 0 다이아몬드  2 클로버 3
	
	// 카드의 너비와 높이는 모든 인스턴스에서 다룰 필요가 없는 값
	// 이런 성질의 변수를 인스턴스 값으로 두면 메모리의 공간이 낭비된다
	static int card_width = 80;
	static int card_height = 150;
	
	public TrumpCard(int rank, int suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	static void setCardWidth(int card_width) {
		TrumpCard.card_width = card_width;
	}
	
	// 스태틱 메서드  : 인스턴스 변수는 활용할 수 없는 메서드
	static void printCardInfo() {
		System.out.println("이 카드의 너비 : " + card_width);
		System.out.println("카드의 높이 : " + card_height);
		//System.out.println("랭크 : " + rank);
	}
	
}

// myobj 패키지에 static 자원을 포함한 클래스를 하나 설계해보세요