package quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

import myobj.RockScissorsPaper;

public class E09_SaveGame {
	/*
	 	컴퓨터와 진행하는 간단한 가위바위보 게임을 만든 후
	 	프로그램 종료시 여태까지의 전적을 파일에 저장해주세요
	 	
	 	프로그램 실행시에는 파일에 저장되어있는 전적 데이터를 읽어 예전 기록이
	 	계속해서 이어지도록 만들어보세요
	 */
	public static void main(String[] args) {
		RockScissorsPaper game = new RockScissorsPaper();
		
		
		while (true) {
			
			Scanner sc = new Scanner(System.in);
			game.game();
			System.out.println("계속 진행하시겠습니까?(Y: 1/N: 2)");
			int con;
			try {
				con = sc.nextInt();		
				
			} catch (InputMismatchException e) {
				System.out.println("다시 입력해주세요");
				sc.nextLine();
				con = sc.nextInt();
			}
			if (con == 1) {
				continue;
			} else if (con == 2) {
				game.stopGame();
				break;
			}
			
		}
	}
}

class isNotAvailableNum extends RuntimeException {
	public isNotAvailableNum() {
		super("1과 2만 입력가능합니다.");
	}
}
