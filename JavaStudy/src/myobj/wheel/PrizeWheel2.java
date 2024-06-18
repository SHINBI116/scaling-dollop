package myobj.wheel;

public class PrizeWheel2 {
	
	// 돌림판의 확률을 결정하는 배열
	Prize[] win = new Prize[360];
	
	// 돌림판의 상품 목록 배열
	Prize[] prizeList = new Prize[5];
	int currIndex = 0;
	
	// 총 각도가 360도를 넘는지 확인위해 필요한 메서드
	private int getTotalDegree() {
		int sum = 0;
		for (int i = 0; i < currIndex; ++i) {
			sum += prizeList[i].getDegree();
		}
		return sum;
	}
	
	// 새 prize를 추가했을 때 총 각도가 360를 넘으면 안됨
	public void add(Prize prize) {
		if (prize.getDegree() < 0) {
			System.out.printf("추가하려는 상품 \"%s\"의 각도가 음수입니다.\n", prize);
			return;
		}
		if (getTotalDegree() + prize.getDegree() > 360) {
			System.out.printf("\"%s\"를 추가하지 못했습니다! (각도 초과)", prize);
			return; // 메서드 강제 종료
		}
		
		prizeList[currIndex++] = prize;
		update();
	}
	
	// prize를 수정했을 때 총 각도가 360를 넘으면 안됨
	public void modifyDegree(int prizeIndex, int degree) {
		
		if (prizeIndex >= currIndex || prizeIndex < 0) {
			System.out.println("[WARN] 상품 수정 도중 에러가 발생했습니다. (인덱스가 올바르지 않음)");
			return; // 현재 메서드 강제종료
		}
		
		Prize toModify = prizeList[prizeIndex];
		
		// 수정하려는 prize의 각도가 올바른지에 대한 처리
		if (degree < 0) {
			System.out.println("[ERROR] 수정하려는 각도가음수");
			return;
		} else if (getTotalDegree() - toModify.getDegree() + degree > 360) {
			System.out.printf("\"%s\"의 각도를 %d도에서 %d도로 수정할 수 없습니다." +
					"(수정시 360도 초과).\n",
					toModify, toModify.getDegree(), degree);
			return;
		}
		
		
		toModify.setDegree(degree);
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
	
	public Prize draw() {		
		return win[(int)(Math.random() * win.length)];
	}
}
