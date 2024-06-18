package quiz;

import java.util.Random;
import java.util.Scanner;

public class B13_Lotto {
	/*
	 	(1) 1 ~ 45 사이의 중복없는 랜덤 숫자 7개를 생성하여 로또 당첨 번호를 만들어 보세요
	 	
	 		1. 숫자를 랜덤으로 뽑는다
	 		2. 뽑았으면 이전에 뽑았던 숫자중에 방금뽑은숫자가 없는지 확인한다
	 		3. 있으면 다시뽑고 없으면 넘어간다
	 	
	 	(2) 1등 또는 2등에 당첨될때까지 랜덤 로또 번호를 계속생성하여
	 	 	몇 번 만에 당첨되었는지 출력해보세요
	 	 	
	 	 	- 로또 구매자는 번호를 6개 고른다
			- 보너스 번호를 제외하고 모두 맞추면 1등
			- 보너스 번호를 포함하여 모두 맞추면 2등
	 */

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] lotto = new int[7];

		for (int i = 0; i < 7; ++i) {
			int lottoNum = ran.nextInt(45) + 1;
			lotto[i] = lottoNum;
			for (int j = 0; j < i; ++j) {
				if (lotto[i] == lotto[j]) {
					--i;
					break;
				}
			}
		}
		
		System.out.print("* 로또 번호 : ");
		for (int i = 0; i < 7; ++i) {
			System.out.printf(" %d ", lotto[i]);
		}
		System.out.println("*");
		
		//2.
		boolean DEBUG_MODE = true;
		boolean not_ans = true;
		int count = 0;
		long countWhile = 1;
		int[] myNums = new int[6];
		
		while (not_ans) {
			for (int i = 0; i < 6; ++i) {
				int lottoNum = ran.nextInt(45) + 1;
				myNums[i] = lottoNum;
				for (int j = 0; j < i; ++j) {
					if (myNums[i] == myNums[j]) {
						--i;
						break;
					}
				}
			}
			
			System.out.print("랜덤 번호 : ");
			for (int i = 0; i < 6; ++i) {
				System.out.printf("%3d", myNums[i]);
			}
			System.out.println();
			
			count = 0;
			for (int i = 0; i < 6; ++i) {				
				for (int j = 0; j < 6; ++j) {
					if (lotto[i] == myNums[j]) {
						++count;
						break;
					}
				}
			}
			if (count == 5) {
				for (int j = 0; j < 6; ++j) {
					if (lotto[6] == myNums[j]) {
						System.out.printf("[%d,%d,%d,%d,%d,%d,%d] ", 
								lotto[0], lotto[1], lotto[2], lotto[3], lotto[4], lotto[5], lotto[6]);
						System.out.println(countWhile + "회 만에 2등");
						not_ans = false;
					}

				}
			}	
			
			if (count == 6) {
				System.out.printf("[%d,%d,%d,%d,%d,%d,%d] ", 
						lotto[0], lotto[1], lotto[2], lotto[3], lotto[4], lotto[5], lotto[6]);
				System.out.println(countWhile + "회 만에 1등");
				not_ans = false;
			}
			
			++countWhile;
		}
		


			
		
	}

}
