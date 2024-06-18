package quiz;

import java.util.Scanner;

public class B12_UpDownGame_Ans {

	public static void main(String[] args) {
		boolean DEBUG_MODE = true;
		
		Scanner sc = new Scanner(System.in);
		
		int answer = (int) (Math.random() * 100 ) + 1;
		int userTry = 0;
		int USER_MAX_TRY = 6;
		
		if (DEBUG_MODE) {
			System.out.println("* 정답은 " + answer + "입니다");
		}
		int userGuess;
		int currMax = 101;
		int currMin = 0;
		while (true) {
			
			if (userTry == 6) {
				System.out.printf("모든 기회를 사용하셨습니다 ... 정답은 %d이었습니다.\n", answer);
				break;
			}
			System.out.print(" >> ");
			userGuess = sc.nextInt();
			
			if (userGuess <= currMin || userGuess >= currMax) {
				System.out.printf("추측 범위를 벗어난 숫자입니다 ... \n"
						+ "현재 추측 범위는 %d초과 %d미만 입니다. (남은기회:%d)\n", currMin, currMax, USER_MAX_TRY - userTry);
				continue;
			}
			
			++userTry;
			
			if (userGuess == answer) {
				System.out.println(userTry + "회 만에 정답! 축하합니다");
				break;
			} else if (userGuess < answer) {
				System.out.printf("UP! (남은기회 : %d)\n", USER_MAX_TRY - userTry);
				currMin = userGuess;
			} else if (userGuess > answer) {
				System.out.printf("Down! (남은기회 : %d)\n", USER_MAX_TRY - userTry);
				currMax = userGuess;
			}
		}
	}

}
