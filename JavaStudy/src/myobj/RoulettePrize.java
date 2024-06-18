package myobj;

public class RoulettePrize {
	
	String name;
	int value;
	int num;
	int degree;
	
	public RoulettePrize(String name, int value, int num, int degree) {
		this.name = name;
		this.value = value;
		this.num = num;
		this.degree = degree;
	}
	
	public int getDegree() {
		return degree;
	}
	
	public int changeDegree(int degree) {
		return this.degree = degree;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNum() {
		return num;
	}
	
	public void minusNum() {
		--this.num;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return String.format("%d원의 가치를 가진 %s[수량: %d, 확률:%.2f%%]", getValue(), getName(),getNum(), getDegree() / 360.0 * 100);
	}
	
	
}
