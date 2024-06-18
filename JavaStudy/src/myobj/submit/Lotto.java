package myobj.submit;


import java.util.Arrays;


public class Lotto {
	/*
 	(1) 1 ~ 45 사이의 중복없는 랜덤 숫자 7개를 생성하여 로또 당첨 번호를 만들어 보세요
 	
 		1. 숫자를 랜덤으로 뽑는다
 		2. 뽑았으면 이전에 뽑았던 숫자중에 방금뽑은숫자가 없는지 확인한다
 		3. 있으면 다시뽑고 없으면 넘어간다
 	
 	(2) 1등 또는 2등에 당첨될때까지 랜덤 로또 번호를 계속생성하여
 	 	몇 번 만에 당첨되었는지 출력해보세요
 	 	
 	 	- 로또 구매자는 번호를 6개 고른다
		- 보너스 번호를 제외하고 모두 맞추면 1등
		- 보너스 번호를 포함하여 모두 맞추면 2등
 */
	

	
	int[] win = new int[7];
	int[] user = new int[6];
	int count = 0;
	boolean isSecond;
	
	public Lotto() {
		draw(win);
		showWin();
	}
	
	private int ranValue() {
		return (int)(Math.random() * 45) + 1;
	}
	
	
	private void drawUntilWin() {
		draw(user);
		count = 0;
		for (int i = 0; i < user.length; ++i) {
			int userNum = user[i];
			for (int j = 0; j < win.length; ++j) {
				if (userNum == win[j]) {
					++count;					
					
				}
			}
		}
				
	}
	
	private boolean isSecond() {
		isSecond = false;
		for (int i = 0; i < user.length; ++i) {
			if (user[i] == win[6]) {
				isSecond = true;
				break;
			} 
		}
		
		return isSecond;
	}
	
	private void draw(int[] n) {
		for (int i = 0; i < n.length; ++i) {
			n[i] = ranValue();
			for (int j = 0; j < i; ++j) {
				if (n[i] == n[j]) {
					--i;
					break;
				}
			}
		}
	}
	private boolean isWin() {	
		if (count == 6) {			
			return true;
		} else {
			return false;
		}
		
	}
	
	public void start() {
		int draw_count = 1;
		while (true) {
					
			drawUntilWin();
			
			if (isWin()) {
				showUser();
				isSecond();
				if (!isSecond) {					
					System.out.printf("%d회만에 1등당첨\n", draw_count);
					
				} else {
					System.out.printf("%d회만에 2등당첨\n", draw_count);
				}
				
				break;
			}
			++draw_count;
		}
	}
	
	
	
	
	public void showWin() {

		StringBuilder sb = new StringBuilder("당첨번호: ");
		sb.append(Arrays.toString(win));
		System.out.println(sb);
	}
	
	public void showUser() {
		
		StringBuilder sb = new StringBuilder("뽑은 번호 : ");
		sb.append(Arrays.toString(user));
		System.out.println(sb);
	}
	
	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.start();
	}
	
}
