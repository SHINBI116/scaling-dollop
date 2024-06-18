package myobj.wheel;

public class Prize_Ex {
	String name;
	int price;
	int amount;
	int degree;
	
	public Prize_Ex(String name, int price, int amount, int degree) {
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.degree = degree;
	}
	
	public void setDegree(int degree) {
		this.degree = degree;
	}
	
	public int minusAmount() {
		return --amount;
	}
	
	public int getAmount() {
		return amount;
	}
	public int getDegree() {
		return degree;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("%d원 가치의 %s\n", price, name);
	}

	
}
