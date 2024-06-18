package myobj;
/*
	# 돌림판을 돌려서 경품을 추첨하는 프로그램을 만들어보세요.
	
	1. 경품들은 경품의 보유가치와 한정된 수량이 있다.
	
	2. 돌림판 인스턴스를 생성한 후 여러 종류의 경품을 추가할 수 있어야 한다
	   
	   돌림판 돌 = new 돌림판();
	   돌.add(경품);
	   돌.add(경품);
	
	3. 돌림판 인스턴스에 추가되어 있는 경품들의 당첨 확률을 수정할 수 있어야 한다.
	
	4. 만약 수량이 모두 소진된 상품에 걸린다면 돌림판을 다시 돌린다
	
*/
public class Roulette {
	RoulettePrize[] win = new RoulettePrize[360];
	RoulettePrize[] prizeList = new RoulettePrize[5];
	
	int currIndex = 0;
	
	public void add(RoulettePrize prize) {
		if (prize.getDegree() < 0) {
			System.out.println("각도가 음수입니다 다시 입력");
			return;
		} else if (prize.getDegree() > 360) {
			System.out.println("각도 초과");
			return;
		} 
		prizeList[currIndex++] = prize;
		update();
	}
	
	private int totalDegree() {
		int sum = 0;
		for (int i = 0; i < prizeList.length; ++i) {
			if (prizeList[i] == null) {
				continue;
			} else {
				sum += prizeList[i].getDegree();
				
			}
		}
		return sum;
	}
	
	public void modifyDegree(int index, int degree) {
		if (index < 0 || index > 360) {
			System.out.println("인덱스오류");
			return;
		}
		
		if (degree < 0 || totalDegree() - prizeList[index].degree + degree > 360) {
			System.out.println(prizeList[index] + "의 각도를 바꿀 수 없습니다");
			return;
		}
		prizeList[index].changeDegree(degree);
		update();
		
	}
	
	private void update() {
		int winIndex = 0;
		for (int i = 0; i < currIndex; ++i) {
			int degree = prizeList[i].getDegree();
			for (int j = 0; j < degree; ++j) {
				win[winIndex++] = prizeList[i];
			}
		}
	}
	
	public RoulettePrize roll() {
		return win[(int)(Math.random() * win.length)];
	}
	
	
	
}
