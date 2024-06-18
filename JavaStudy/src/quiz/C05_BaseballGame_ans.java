package quiz;

import java.util.Scanner;

import myobj.BaseballGame;

public class C05_BaseballGame_ans {
	public static void main(String[] args) {
		boolean DEBUG_MODE = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			BaseballGame game = new BaseballGame();
			
			if (DEBUG_MODE) {
				game.printAnswer();
			}
			while (true ) {
				System.out.print("숫자 4개를 입력 > ");
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				int d = sc.nextInt();
				
				int[] result = game.guessNumber(a, b, c, d);
				
				game.minusChance();
				
				int chance = game.getChance();
				
				System.out.printf("%dstrike, %dball (남은기회: %d)\n",
						result[0], result[1], chance);
				
				if (result[0] == 4) {
					System.out.println("플레이어의 승리입니다!");
					System.out.println("새로운 게임!");
					System.out.println("----------------------------");
					break;
				} else if (chance == 0) {
					System.out.println("플레이어의 패배입니다 ...");
					System.out.println("다음 게임을 진행합니다");
					System.out.println("----------------------------");
					break;
				}
			}
				
		}
	}
}
