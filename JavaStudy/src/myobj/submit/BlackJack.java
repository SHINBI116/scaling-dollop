package myobj.submit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*
	1. 컴퓨터(딜러)와 사람(플레이어)이 카드를 뽑아야 한다.
	
	2. 처음에는 둘 모두 2장씩 받는다. 이 때 딜러의 카드는 한장 가려놓아야 한다.
	
	3. 플레이어는 카드를 받은 후 상황을 보고 계속 뽑을지(hit) 그만 뽑을지(stand)를 결정해야한다.
	
	4. 플레이어가 hit를 선택하면 카드를 한 장 더 받는다.
	
	5. 플레이어가 stand를 선택하면 딜러가 가려놨던 카드를 오픈한 후 카드를 뽑기 시작한다.
	   이 때 딜러는 의사 결정을 할 수 없고 정해진 규칙에 따라야 한다.
	   
	   ※ 딜러의 규칙 - 가진 카드의 합의 16이하라면 뽑는다. 17이상이면 멈춘다.
	   
	6. J, Q, K는 모두 10의 가치를 지닌다
	
	7. A는 필요에 따라 1로 쓸 수도 있고 11로 쓸 수도 있다
	  (A는 11의 가치를 지니고 있다가 카드의 합이 21이 넘어가면 1이 된다)
	  
	8. 가진 카드의 함이 21을 넘어가면 버스트, 정확하게 21이면 블랙잭이다.
   	플레이어가 버스트를 당하면 딜러는 카드를 뽑지도 않고 승리한다.
*/
public class BlackJack {
	final static Scanner sc = new Scanner(System.in);
	Player player, dealer;
	Deck deck;
	
	class Card {
		final static char[] SUITS = {'♠', '♡', '◇', '♣'};
		final static String[] RANKS = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
		
		final static int[] VALUES = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		
		final public static int NUM_OF_SUITS = SUITS.length;
		final public static int NUM_OF_RANK = RANKS.length;
		
		int suit; // ♡◇♠♣
		int rank; // A ~ K
		
		public Card(int suit, int rank) {
			this.suit = suit;
			this.rank = rank;
		}
		
		public int getValue() {
			return VALUES[rank];
		}
		
		@Override
		public String toString() {
			return String.format("%c%s", SUITS[suit], RANKS[rank]);
		}
	}
	
	interface Deck {
		
		void shuffle();
		 
		Card draw();
					
	}
	
	class CardsImp implements Deck {
		
		LinkedList<Card> cards = new LinkedList<>();
		
		public CardsImp() {
			reset();
		}
		
		private void reset() {
			for (int suit = 0; suit < Card.NUM_OF_SUITS; ++suit) {
				for (int rank = 0; rank < Card.NUM_OF_RANK; ++rank) {
					cards.add(new Card(suit, rank));
				}
			}
			shuffle();
		}
		
		@Override
		public void shuffle() {
			Collections.shuffle(cards);
			
		}

		@Override
		public Card draw() {
			Card card = cards.pollFirst();			
			if (card == null) {
				reset();

				return draw();
			}
			
			return card;
		}

	}
	
	class Player {
		final public static int USER_PLAYER = 0;
		final public static int DEALER_NOT_OPEN = 1;
		final public static int DEALER_OPEN = 2;
		
		int printType; // 0이면 일반 플레이어 1이면 카드 가려놓는 딜러, 2면 카드 오픈하는 딜러
		int money;
		List<Card> hand = new ArrayList<>();
		
		public Player(int printType, int money) {
			this.printType = printType;
			this.money = money;
		}
		
		public void addCard(Card card) {
			hand.add(card);
		}
		
		public List<Card> getHand() {
			return hand;
		}
		
		public void setPrintType(int printType) {
			this.printType = printType;
		}
		
		public void printHand() {
			if (printType == 0) {
				System.out.printf("플레이어: %s (%d)\n", hand, BlackJackLogic.getValue(hand));
			} else if (printType == 1) {
				System.out.printf("딜러: □ %s\n", hand.get(1));
			} else if (printType == 2) {
				System.out.printf("딜러: %s (%d)\n", hand, BlackJackLogic.getValue(hand));
			}
		}
		
		public void resetHand() {
			while (hand.size() > 0) {
				hand.remove(0);
			}
		}
		
		public void printMoney() {
			System.out.println(money);
		}
		
		public void earnMoney(int money) {
			this.money += money;
		}
		
		public void lossMoney(int money) {
			this.money -= money;
		}
		
		public int getMoney() {
			return this.money;
		}
	}
	
	class BlackJackLogic {
		final public static int PLAYER_WIN = 0;
		final public static int DEALER_WIN = 1;
		final public static int PUSH = 2;
		
		static int getValue(List<Card> cards) {
			int sum = 0;
			int aceCount = 0;
			
			for (Card card : cards) {
				int value = card.getValue();
				sum += value;
				
				if (value == 11) {
					++aceCount;
				}
			}
			
			while (aceCount > 0 && sum > 21) {
				sum -= 10;
				--aceCount;
			}
			
			return sum;
		};
		
		static int check(List<Card> playerCards, List<Card> dealerCards) {
			int v1 = getValue(playerCards);
			int v2 = getValue(dealerCards);
			
			if (v1 > 21) {
				return DEALER_WIN;
			} else if (v2 > 21) {
				return PLAYER_WIN;
			} else if (v1 > v2) {
				return PLAYER_WIN;
			} else if (v1 < v2) {
				return DEALER_WIN;
			} else {
				return PUSH;
			}

		};
	}
	
	public BlackJack() {
		player = new Player(0, 3000);
		dealer = new Player(1, 0);
		
		deck = new CardsImp();
	}
	
	private int betMoney(int money) throws ExceedPlayerMoney {
		int curr = player.getMoney();
		if (money > curr) {
			throw new ExceedPlayerMoney(
					String.format("%d원은 소지금 %d원 보다 큽니다\n다시 입력해주세요", money, curr));
		}
		return money;
	}
	
	public void gameStart() throws InterruptedException, ExceedPlayerMoney {
		System.out.println("#### 블랙잭 ####");
		
		while (true) {
			System.out.print("베팅 금액 > ");
			int bet;
			try {
				 bet = betMoney(sc.nextInt());
			} catch (ExceedPlayerMoney e) {
				System.out.println(e.getMessage());
				continue;
			}
			
			
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
					
					int value = BlackJackLogic.getValue(player.getHand());
					
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
			
			if (BlackJackLogic.getValue(player.hand) <= 21) {
				// 딜러가 카드를 뽑는 곳 (16이하라면 계속 뽑는다, 플레이어가 버스라면 뽑지않아도된다)	
				while (BlackJackLogic.getValue(dealer.getHand()) <= 16) {
					dealer.addCard(deck.draw());
					dealer.printHand();
					Thread.sleep(1000); // 현재 프로그램을 1초 멈춘다
				}
			}
			int result = BlackJackLogic.check(player.getHand(), dealer.getHand());
			
			switch (result) {
				case BlackJackLogic.PLAYER_WIN:
					player.earnMoney(bet);
					System.out.println("플레이어가 이겼습니다!");
					System.out.println("현재 플레이어의 소지금 : " + player.getMoney());
					break;
				case BlackJackLogic.DEALER_WIN:
					player.lossMoney(bet);
					System.out.println("딜러가 이겼습니다!");
					System.out.println("현재 플레이어의 소지금 : " + player.getMoney());
					break;
				case BlackJackLogic.PUSH:
					System.out.println("비겼습니다!");
					break;
			}
			
			player.resetHand();
			dealer.resetHand();
			// 소지금 0원시 게임종료
			if (player.getMoney() == 0) {
				System.out.println("게임 종료");
				break;
			}
		}
	}
	
	class ExceedPlayerMoney extends Exception {
		public ExceedPlayerMoney(String message) {
			super(message);
		}
	}
	
	Card testGetCard(int suit, int rank) {
		return new Card(suit, rank);
	}
	
	
	public static void main(String[] args) throws InterruptedException, ExceedPlayerMoney {
		BlackJack game = new BlackJack();
		
		game.gameStart();
	}
}



