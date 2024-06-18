package myobj.submit;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {
	/*
		숫자 야구 게임을 만들어보세요
	
		1. 게임이 시작되면 정답이 랜덤으로 생성된다
		   (정답은 랜덤 4자리의 중복없는 숫자)
		2. 플레이어에게는 9번의 기회가 주어지며 4자리의 숫자를 마음대로 입력할 수 있다
		3. 플레이어가 입력한 숫자의 번호와 위치가 정답의 것과 모두 일치하면 스트라이크
		4. 플레이어가 입력한 숫자는 맞고 위치가 다르면 볼
		5. 9번의 기회 안에 모든 숫자와 위치를 맞추면 사용자의 승리
		6. 모든 기회 소진시 플레이어의 패배
	
		ex> 정답 : 2591 경우
	
			플레이어가 2988이라고 입력 > 1strike 1ball

*/
	class Result {
		int strike;
		int ball;
		
		public int plusStrike() {
			return ++strike;
		}
		
		public int plusBall() {
			return ++ball;
		}
		
		public int getStrike() {
			return strike;
		}
		
		public int resetStrike() {
			return strike = 0;
		}
		
		public int resetBall() {
			return ball = 0;
		}
		
		@Override
			public String toString() {
				return String.format("%dstrike %dball\n", strike, ball);
			}
	}
	
	
	int[] ans = new int[4];
	int[] user = new int[4];
	static int chance = 9;
	boolean DEBUG_MODE = false;
	Result result = new Result();
	
	public BaseballGame() {
		ans = constructAns();
	}
	
	public boolean setDEBUG_MODE(boolean DEBUG_MODE) {
		this.DEBUG_MODE = DEBUG_MODE;
		return DEBUG_MODE;
	}
	
	private int[] constructAns() {
		for (int i = 0; i < ans.length; ++i) {
			int ran = (int)(Math.random() * 10);
			ans[i] = ran;
			for (int j = 0; j < i; ++j) {
				if (ans[i] == ans[j]) {
					--i;
					break;
				}
			}
		}
		return ans;
	}
	
	public Result guessNum(int[] num) {
		
		for (int i = 0; i < num.length; ++i) {
			if (num[i] == ans[i]) {
				result.plusStrike();
			} else {
				for (int j = 0; j < num.length; ++j) {
					if (num[j] == ans[i] && j != i) {
						result.plusBall();
					}
				}
			}
		}
		--chance;
		return result;
	}
	
	
	
	
	public String showAns() {
		return Arrays.toString(ans);
	}
	
	public static int getChance() {
		return chance;
	}

	private int inputNum(int num) throws NotAvailableGuess {
		if (num < 0 || num > 9) {
			throw new NotAvailableGuess();
		}
		
		return num;
	}
	
	
	static class BaseballConsole {
		
	}
	public void gameStart() {
		Scanner sc = new Scanner(System.in);
		if (DEBUG_MODE) {
			System.out.println("정답 : " + showAns());
		}
		while (true) {
			System.out.printf("숫자 4자리를 입력해주세요 (남은기회%d회) > ", getChance());			
				int num;
					try {			
						user[0] = inputNum(sc.nextInt());
						user[1] = inputNum(sc.nextInt());
						user[2] = inputNum(sc.nextInt());
						user[3] = inputNum(sc.nextInt());
					} catch (NotAvailableGuess e) {
						System.out.println(e.getMessage());
						sc.nextLine();
						continue;
					}

			if (DEBUG_MODE) {
				System.out.println(Arrays.toString(user));
			}
			System.out.print(guessNum(user));
						
			
			if (gameEnd()) {
				break;
			}
			
			result.resetBall();
			result.resetStrike();
			
		}
	}
	
	private boolean gameEnd() {
		if (getChance() == 0) {
			System.out.println("기회를 모두 소진하였습니다");
			System.out.println("정답: " + showAns());
			return true;
		}
		
		if (result.getStrike() == 4) {
			System.out.println("정답입니다.");
			return true;
		}
		
		return false;
	}
	
	class NotAvailableGuess extends Exception {
		public NotAvailableGuess() {
			super("추측범위는 0 ~ 9 사이의 숫자입니다. 다시 입력해주세요");
		}
	}
	
	public static void main(String[] args) {

		while (true) {
			BaseballGame game = new BaseballGame();
			game.setDEBUG_MODE(true);
			game.gameStart();
		}
		
	}
	
	
}
