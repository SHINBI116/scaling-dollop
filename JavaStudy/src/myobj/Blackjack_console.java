package myobj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Blackjack_console {
	
	public Blackjack_console() {
		
	}

	public static void start() {
		Scanner sc = new Scanner(System.in);
		Blackjack game = new Blackjack();
		while (true) {
			int playerSum = game.sumCardValueP();
			int cpuSum = game.sumCardValueC();
			System.out.println("플레이어 : " + game.showPlayer());
			System.out.println(playerSum);
			game.cpuPrint();
			
			System.out.println("hit? stand? >> ");
			String cmd = sc.next();
			cmd = cmd.toLowerCase();
			char ch = cmd.charAt(0);
			int previousCpu = 0;
			if (ch == 'h') {
				game.selectHit();
				playerSum = game.sumCardValueP();
			} else if (ch == 's') {
				previousCpu = game.sumCardValueC();
				game.selectStand();
				cpuSum = game.sumCardValueC();
				System.out.println("cpu : " + game.showCpu());
				System.out.println(cpuSum);
				System.out.println("------------------------------");
			}
			
			
			if (playerSum == 21) {
				System.out.println("플레이어 : " + game.showPlayer());
				System.out.println(playerSum);
				System.out.println("cpu : " + game.showCpu());
				System.out.println(cpuSum);
				System.out.println("블랙잭");
				System.out.println("플레이어의 승리! 게임종료");
				break;
			} else if (playerSum >= 21) {
				System.out.println("플레이어 : " + game.showPlayer());
				System.out.println(playerSum);
				System.out.println("cpu : " + game.showCpu());
				System.out.println(cpuSum);
				System.out.println("플레이어 패배! 게임종료");
				break;
			}
			if (cpuSum == 21) {
				System.out.println("플레이어 : " + game.showPlayer());
				System.out.println(playerSum);
				System.out.println("cpu : " + game.showCpu());
				System.out.println(cpuSum);
				System.out.println("딜러 블랙잭");
				System.out.println("플레이어 패배! 게임종료");
				break;
			} else if (cpuSum >= 21) {
				System.out.println("플레이어 : " + game.showPlayer());
				System.out.println(playerSum);
				System.out.println("cpu : " + game.showCpu());
				System.out.println(cpuSum);
				System.out.println("플레이어의 승리! 게임종료");
				break;
			} else if (previousCpu == cpuSum) {
				playerSum -= 21;
				cpuSum -= 21;
				if ((Math.abs(playerSum)) < (Math.abs(cpuSum))) {		
					System.out.println("플레이어의 승리! 게임종료");
					break;
				} else if ((Math.abs(playerSum)) > (Math.abs(cpuSum))) {
					System.out.println("플레이어 패배! 게임종료");
					break;
				} else {
					System.out.println("push");
					break;
				}
			}
		}
	}
	public static void main(String[] args) {
		start();
	}
}