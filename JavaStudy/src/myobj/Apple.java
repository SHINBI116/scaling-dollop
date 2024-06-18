package myobj;

public class Apple {
	int price ;
	double weight;
	
	// 이 생성자를 통해 만들어지는 사과 인스턴스들은
	// 가격이 1000, 무게가 5가된다
	// 생성자가 더 나중에 초기화
	public Apple() {
		price = 1000;
		weight = 5;
	}
	// 이 생성자를 통해 만들어지는 인스턴스들은 가격은 받은걸로 채우고 무게는 10으로 설정하겠다
	public Apple(int price) {
		this.price = price;
		weight = 10;
	}
	
	// 이 생성자를 통해 만들어지는 인스턴스들은 가격은 1500 무게는 받은걸로 채우겠다
	public Apple(double weight) {
		price = 1500;
		this.weight = weight;
		}
		
	// 이생상자를 통해 만들어지는 인스턴스들은 두 변수의 값을 직접 설정하겟다
	public Apple(int price, double weight) {
		this.price = price;
		this.weight = weight;
		}
	
	public void print() {
		System.out.println("사과 " + this + "의 가격: " + price);
		System.out.println("사과 " + this + "의 무게: " + weight);
	}

}
