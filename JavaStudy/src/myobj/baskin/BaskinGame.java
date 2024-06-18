package myobj.baskin;

public class BaskinGame {
	// 기본적으로 0으로 초기화(배열과 동일)
	int playerNum;
	int lastNum;
	int currentNum; // 초기화하지 않은 인스턴스 변수는 배열처럼 기본값을 갖고있다
	
	// 기본생성자 : 매개변수가 아무것도 없는 생성자 (현재 없음)
	//메게변수x 기본생성자x
	public BaskinGame(int lastNum) {
		this.lastNum = lastNum;
	}
	
	/**
	 * @param num - 사용자가 게임을 위해 선택한 숫자를 전달해주세요
	 * @return -1 : 사용자가 1 ~ 3을 벗어나는 값을 입력한 경우
	 * -2: 사용자가 마지막값을 벗어나는 숫자를 더하려고 하는 경우 
	 */
	public int next(int num) {
		if (num < 1 || num > 3) {
			return -1;
		} else if (currentNum + num > lastNum) {
			return -2;
		}
		return currentNum += num;
	}
	
	public boolean isEnd() {
		return currentNum == lastNum;
	}
}
