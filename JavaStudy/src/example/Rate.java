package example;

public class Rate {
	// 확률 만드는 법
	public static void main(String[] args) {
		
		// 360분의 5 확률 만들기..
		boolean[] prizeWin = new boolean[360];
		
		prizeWin[0] = true;
		prizeWin[1] = true;
		prizeWin[2] = true;
		prizeWin[3] = true;
		prizeWin[4] = true;
		
		int winCount = 0;
		for (int i = 0; i < 100; ++i) {
			int ran = (int)(Math.random() * prizeWin.length);
			System.out.println("당첨인가요 ? " + 
		prizeWin[ran]);
			
			if (prizeWin[ran]) {
				++winCount;
			}

		}
		System.out.printf("확률 %.2f%%짜리 경품 당첨된 횟수 : %d\n",
				5.0 / prizeWin.length * 100, winCount);
	}

}
