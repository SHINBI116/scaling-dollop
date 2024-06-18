package quiz;

import java.util.Scanner;

public class B12_UpDownGame {
	/*
	 	# UpDown 게임을 만들어보세요
	 	1. 게임이 시작되면 1~ 100 사이의 랜덤 숫자가 정답이 된다
	 	
	 	2. 사용자가 숫자를 입력하면 Up인지 Down인지 알려준다
	 	
	 	3. 만약 사용자가 현재 추측 범위를 숫자를 입력했다면 
	 	기회를 소진하지 않고 다시 입력할 수 있는 기회를 준다
	 	
	 	ex>
	 	50
	 	down (남은 기횐 4회)
	 	75
	 	추측 범위를 벗어난 숫자입니다 .. (남은 기회 4회)
	 	
	 	4. 6번 안에 못맞추면 정답이 뭐였는지 알려주고 프로그램을 종료합니다.
	 	
	 	5. 사용자가 정답을 맞추면 축하한다고 해주고 프로그램을 종료
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean DEBUG_MODE = false;
		
		int answerNum = (int) (Math.random() * 101 + 1);
		int previousNum = 0;
		if (DEBUG_MODE) {
			System.out.println("답 : " + answerNum);
		}
		System.out.println("숫자를 입력하시오 > ");
		
		for (int i = 1; i <= 6; ++i) {
			int myNum = sc.nextInt();
			int chance = 6 - i;
			if (DEBUG_MODE) {
				System.out.println("이전숫자 : " + previousNum);
			}
			if (myNum < answerNum) {
				if (previousNum < myNum) {
					System.out.printf("Up (남은 기회 %d회)\n", chance);
				} else {
					chance += 1;
					System.out.printf("추측 범위를 벗어난 숫자입니다 .. (남은 기회 %d회)\n", chance);
					
				}
				
			} else if (myNum > answerNum) {
				System.out.printf("Down (남은 기회 %d회)\n", chance);
			} else {
				System.out.println("축하합니다 정답입니다.");
				break;
			}
			previousNum = myNum;
			if (DEBUG_MODE) {
				System.out.println("i : " + i + "이전숫자는 " + previousNum);
			}
			if (i == 6) {
				System.out.println("정답은 " + answerNum + "입니다.");
			}
			
		}
	}

}
