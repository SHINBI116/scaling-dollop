package myobj;

import java.util.Scanner;

public class Omok_Console {
	public static void main(String[] args) {
		Omok omok = new Omok();
		
		Omok_player black = new Omok_player('●');
		Omok_player white = new Omok_player('○');
		
		Scanner sc = new Scanner(System.in);
		
		omok.printPan();
		
		int turn = 0;
		int x, y;
		
		while(true) {
			if (turn % 2 == 0) {
				System.out.printf("%c차례 :좌표를 입력해주세요(%d턴): ", black.stone, turn + 1);
				x = sc.nextInt();
				y = sc.nextInt();
				
				if (omok.isStone(x, y)) {
					black.setStone(x, y);
				} else {
					System.out.println("이미 놓여져 있습니다.");
					continue;
				}
				
				if (black.widthWin(x) == 5 || black.heightWin(y) == 5) {
					System.out.println("검은돌 승리");
					break;
				} 
			} else {
				System.out.printf("%c차례 :좌표를 입력해주세요(%d턴): ", white.stone, turn + 1);
				x = sc.nextInt();
				y = sc.nextInt();
				
				if (omok.isStone(x, y)) {
					white.setStone(x, y);
				} else {
					System.out.println("이미 놓여져 있습니다.");
					continue;
				}
				if (white.widthWin(x) == 5 || white.heightWin(y) == 5) {
					System.out.println("하얀돌 승리");
					break;
				}
			}
			
			
			++turn;
		}
	}
}
