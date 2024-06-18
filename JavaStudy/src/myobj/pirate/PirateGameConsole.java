package myobj.pirate;

import java.util.Arrays;
import java.util.Scanner;

public class PirateGameConsole {
	
	Scanner sc = new Scanner(System.in);
	
	PirateGamePlayer[] players = new PirateGamePlayer[4];
	PirateGame game = new PirateGame();
	
	int turn = 0;
	boolean DEBUG_MODE = true;
	
	public PirateGameConsole() {
		players[0] = new PirateGamePlayer("유재석");
		players[1] = new PirateGamePlayer("강호동");
		players[2] = new PirateGamePlayer("추신수");
		players[3] = new PirateGamePlayer("이만기");
	}
	
	public void printAllPlayers() {
		players[0].print();
		players[1].print();
		players[2].print();
		players[3].print();
	}
	
	public PirateGamePlayer[] getOrderedPlayers() {
		// 플레이어들을 복사한 배열을 준비해서 정렬한다 (원본을 해치지 않기 위함)
		PirateGamePlayer[] copied = Arrays.copyOf(players, players.length);
		
		// 플레이어들의 점수를 기준으로 순서를 재배치 한다
		for (int i = 0; i < copied.length; ++i) {
			for (int j = 0; j < copied.length - 1 - i; ++j) {
				if (copied[j].rating < copied[j + 1].rating) {
					PirateGamePlayer temp = copied[j];
					copied[j] = copied[j + 1];
					copied[j + 1] = temp;
				}
			}
		}
		
		return copied;
	}
	
	public void printEndInfo() {
		// 현재까지의 점수를 기준으로 순위를 매긴다
		// 점수 기준으로 순위가 정렬된 배열을 하나 생성한다
		// (점수가 같으면 앞에 있던 사람이 1등)
		PirateGamePlayer[] ordered = getOrderedPlayers();
		
		System.out.println("#### 최종결과 ####");
		ordered[0].print(1000);
		ordered[1].print(500);
		ordered[2].print(-500);
		ordered[3].print(-1000);
	}
	
	public void start() {
		while (true) {
			int currPlayerIndex = turn % players.length;
			PirateGamePlayer currPlayer = players[turn % players.length];
			if (DEBUG_MODE) {
				game.showAnswer();
			}
			game.print();
			System.out.printf("[%d턴]\"%s\"님의 차례 > ", 
					turn + 1, currPlayer.name);
			int userInput = sc.nextInt();
			
			if (userInput < 1 || userInput > 20) {
				System.out.println("[WARNING] 1 ~ 20 사이의 숫자만 입력해주세요!!");
				continue;
			}
			int result = game.stab(userInput - 1);
			
			if (result == PirateGame.STABBED_HOLE) {
				System.out.println("이미 찔렀던 곳은 다시 선택할 수 없습니다!!");
				continue;
			} else if (result == PirateGame.SAFE_HOLE) {
				currPlayer.survive();
				++turn;
			} else if (result == PirateGame.LAUNCH_HOLE) {
				System.out.println("통아저씨가 하늘 높이 날아갑니다 ...");
				System.out.printf("\"%s\"님의 패배입니다.\n", currPlayer.name);
				
				boolean deadPlayerExists = false;
				for (int i = 0; i < players.length; ++i) {
					if (i == currPlayerIndex) {
						players[i].ratingDown(3000);
						deadPlayerExists = players[i].rating < 0;
					} else {
						players[i].ratingUp(500);
					}
					
				}
				if (deadPlayerExists) {
					System.out.printf("\"%s\"님의 점수가 마이너스이므로 게임을 종료합니다!!",
							currPlayer.name);
					printAllPlayers();
					break;
				} 
				
				sc.nextLine();
				printAllPlayers();
				System.out.println("게임을 더 진행하시겠습니까? (Y/N)");
				String select = sc.next();
				char cmd = select.charAt(0);
				
				if (cmd == 'Y' || cmd == 'y') {
					
					turn = 0;
					game.shuffle();
					System.out.println("새 게임이 시작됩니다!");
				} else if (cmd == 'N' || cmd == 'n') {
					System.out.println("그만하기를 선택하셔서 게임 종료");
					break;
				}
			}
			
		}
		printEndInfo();	
	}

	
	public static void main(String[] args) {
		new PirateGameConsole().start();
	}
}
