package myobj;

import java.util.Arrays;
import java.util.Scanner;

public class Game31 {

	int playerNum;	
	int endNum;
	int lastPickNum = 0;
	
	/**
	 * @param num1 - 게임참여인원수
	 * @param num2 - 마지막숫자
	 */
	public Game31(int playerNum, int endNum) {
		this.playerNum = playerNum;
		this.endNum = endNum;
	}
	
	public void printSet() {
		System.out.printf("인원수 : %d 마지막숫자:%d\n", playerNum, endNum);
	}
	
	/**
	 
	 * @param plusNum - 사용자가 더할  수 있는 수 1 ~ 3
	 * 		 lastPickNum - 제일 마지막으로 플레이어가 부른 숫자
	 * 		-1 - 에러
	 * 		마지막수보다 고른수가 크면 마지막수 리턴
	 * @return
	 */
	public int pickNum(int plusNum) {
		if (plusNum < 1 || plusNum > 3) {
			return -1;
		}
		lastPickNum += plusNum;
		if (lastPickNum > endNum) {
			return endNum;
		} else {
			return lastPickNum;
		}
	}
	
	public void printPickNum() {
		System.out.println("현재 나온 제일 마지막수는 " + lastPickNum);
	}
	
	public int showPlayerNum() {
		return playerNum;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("인원수 입력 > ");
		int playersNum = sc.nextInt();
		System.out.println("마지막 숫자 입력 > ");
		int lastNum = sc.nextInt();
		Game31 iceCream = new Game31(playersNum, lastNum);
		while (true) {
			iceCream.printSet();
			System.out.println("숫자입력 > ");
			int result = iceCream.pickNum(sc.nextInt());
			iceCream.printPickNum();
			if (result == -1) {
				System.out.println("다시 입력해주세요.");
				continue;
			} else if (result == lastNum) {
				System.out.println("마지막수 입력!");
				break;
			}
		}
		
	}

	
	
	
}
