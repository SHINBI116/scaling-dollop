package myobj.pirate;

import java.util.Arrays;
import java.util.Scanner;

public class PirateGame {
	int[] holes = new int[20];
	
	public final static int LAUNCH_HOLE_COUNT = 4;
	public final static int SAFE_HOLE = 0;
	public final static int LAUNCH_HOLE = 1;
	public final static int STABBED_HOLE = 2;
	
	public PirateGame() {
		shuffle();
	}
	
	/**
	 	이 메서드를 호출하면 칼 구멍 배열을 뒤섞어줍니다. 
	 	새로운 게임을 시작하고 싶을 때 호출해서 사용하세요.
	 */
	public void shuffle() {
		for (int i = 0; i < holes.length; ++i) {
			if (i < LAUNCH_HOLE_COUNT) {
				holes[i] = LAUNCH_HOLE;
			} else {
				holes[i] = SAFE_HOLE;
			}
		}
		
		for (int i = 0; i < 100; ++i) {
			int ranIndex = (int)(Math.random() * (holes.length - 1)) + 1;
			
			int temp = holes[0];
			holes[0] = holes[ranIndex];
			holes[ranIndex] = temp;
		}
	}
	
	/**
	 * @param index - 찌르고 싶은 위치를 전달해주세요	
	 * @return 
	 * 		    <b>0</b>: 아무것도 아닌 구멍입니다.<br>
	 * 		   <b>1</b>: 꽝, 아저씨가 발사됩니다. <br>
	 * 		   <b>2</b>: 이미 찔렀던 위치입니다.
	 */
	public int stab(int index) {
		switch(holes[index]) {
			case SAFE_HOLE:
				holes[index] = STABBED_HOLE;
				return SAFE_HOLE;
			default:
				return holes[index];
		}		
		
	}
	
	public void print() {
		int i = 0;
		System.out.println("----------------------------");
		for (int line = 0; line < 4; ++line) {
			for (int column = 0; column < 5; ++column) {
				switch (holes[i]) {
					case STABBED_HOLE:
						System.out.printf("%-4c", 'X');
						break;
					default:
						System.out.printf("%02d  ", i + 1);
						break;
				}
				++i;
			}
			System.out.println();
		}
	}
	
	public void showAnswer() {
		System.out.println(Arrays.toString(holes));
	}
	
	public static void main(String[] args) {
		PirateGame game = new PirateGame();
		
		game.showAnswer();
		
		System.out.println("---테스트용 콘솔입니다---");
		Scanner sc = new Scanner(System.in);
		
		int stabResult = -1;
		
		while (stabResult != 1) {
			game.print();
			System.out.println(">");
			stabResult = game.stab(sc.nextInt() - 1);
			System.out.println("찌른 결과는 " + stabResult + "이었습니다. ");
		}
		System.out.println("아저씨가 발사되고 게임이 끝났습니다.");
	}
}
