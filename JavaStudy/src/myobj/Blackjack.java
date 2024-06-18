package myobj;

import java.util.*;

public class Blackjack {
	ArrayList<Integer> deck = new ArrayList<>();
	LinkedList<Integer> player = new LinkedList<>();
	LinkedList<Integer> cpu = new LinkedList<>();
	private Integer A = Integer.valueOf(11);
	private int J = 10, Q = 10, K = 10;
	
	
	final static String[] HIT_STAND = {"hit", "stand"};
	
	public Blackjack() {
		Collections.addAll(deck, A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K);
		Collections.shuffle(deck);		
		player.add(deck.get((int)(Math.random() * deck.size())));
		player.add(deck.get((int)(Math.random() * deck.size())));
		cpu.add(deck.get((int)(Math.random() * deck.size())));
		cpu.add(deck.get((int)(Math.random() * deck.size())));
		sumCardValueP();
		sumCardValueC();
	}
	
	public int sumCardValueP() {
		int playerSum = 0;
		int countA = 0;
		int i = 0;
		for (i = 0; i < player.size(); ++i) {
			playerSum += player.get(i);
			if (player.get(i) == A) {
				++countA;
			}
		}
		if (countA != 0 && playerSum >= 21) {
			playerSum -= 10 * countA;
		}
		// A가 나온적이 있고, 21이 넘었다면 10을 뺀다
		
		return playerSum;

	}
	
	public int sumCardValueC() {
		int cpuSum = 0;
		int i = 0;
		int countA = 0;
		for (i = 0; i < cpu.size(); ++i) {
			cpuSum += cpu.get(i);
			if (cpu.get(i) == A) {
				++countA;
			}
		}
		if (countA != 0 && cpuSum >= 21) {
			cpuSum -= 10 * countA;
		}
		return cpuSum;

	}
	
	public LinkedList<Integer> showPlayer() {
		return player;
	}
	
	
	
	public LinkedList<Integer> showCpu() {
		return cpu;
	}
	
	public void cpuPrint() {
		System.out.println("[" + cpu.get(0) + ", *]");
	}
	
	
	public void selectHit() {
		player.add(deck.get((int)(Math.random() * deck.size())));
		sumCardValueP();
	}
	
	public void selectStand() {
		while(true) {
			if (sumCardValueC() <= 16) {
				cpu.add(deck.get((int)(Math.random() * deck.size())));
				sumCardValueC();
			} else {
				break;
			}
		}
	}
	
	public void showDeck() {
		System.out.println(deck);
	}
}
