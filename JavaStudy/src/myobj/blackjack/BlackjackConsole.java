package myobj.blackjack;

import java.util.Scanner;

public class BlackjackConsole {
	
	final static Scanner sc = new Scanner(System.in);
	

	
	public static void main(String[] args) throws InterruptedException {
		Player player = new Player(0, 3000);
		Player dealer = new Player(1, 0);
		
		CardDeck deck = new CardDeckImpl();
		
		System.out.println("#### 블랙잭 ####");
		
		while (true) {
			System.out.print("베팅 금액 > ");
			int bet = sc.nextInt();
			
			player.addCard(deck.draw());
			player.addCard(deck.draw());
			
			dealer.setPrintType(player.DEALER_NOT_OPEN);
			dealer.addCard(deck.draw());
			dealer.addCard(deck.draw());
			

			player.printHand();
			dealer.printHand();
			
			while (true) {
				System.out.print("1: hit\t2:stand\n>  ");
				int select = sc.nextInt();
				
				if (select == 1) {
					player.addCard(deck.draw());
					player.printHand();
					
					int value = GameLogic.getValue(player.getHand());
					
					if (value >= 21) {
						break;
					}
				} else if (select == 2) {
					break;
				} else {
					System.out.println("제대로 골라주세요.....");
				}
			}
			
			player.printHand();
			dealer.setPrintType(player.DEALER_OPEN);
			dealer.printHand();
			
			if (GameLogic.getValue(player.hand) <= 21) {
				// 딜러가 카드를 뽑는 곳 (16이하라면 계속 뽑는다, 플레이어가 버스라면 뽑지않아도된다)	
				while (GameLogic.getValue(dealer.getHand()) <= 16) {
					dealer.addCard(deck.draw());
					dealer.printHand();
					Thread.sleep(1000); // 현재 프로그램을 1초 멈춘다
				}
			}
			int result = GameLogic.check(player.getHand(), dealer.getHand());
			
			switch (result) {
				case GameLogic.PLAYER_WIN:
					player.earnMoney(bet);
					System.out.println("플레이어가 이겼습니다!");
					System.out.println("현재 플레이어의 소지금 : " + player.getMoney());
					break;
				case GameLogic.DEALER_WIN:
					player.lossMoney(bet);
					System.out.println("딜러가 이겼습니다!");
					System.out.println("현재 플레이어의 소지금 : " + player.getMoney());
					break;
				case GameLogic.PUSH:
					System.out.println("비겼습니다!");
					break;
			}
			
			player.resetHand();
			dealer.resetHand();
		}
	}
}
