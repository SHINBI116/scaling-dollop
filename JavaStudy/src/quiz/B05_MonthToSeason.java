package quiz;

import java.util.Scanner;

public class B05_MonthToSeason {

	/*
	 * 사용자로부터 몇월인지 입력받으면 해당하는 계절을 출력해보세요 (switch-case문으로 한번,if문으로 한번씩)
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int month;
		String m;
		
		System.out.printf("몇월? > ");
		month = sc.nextInt();

		switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.printf("swich: %d월은 봄입니다.\n", month);
				break;
			case 6:
			case 7:
			case 8:
				System.out.printf("swich: %d월은 여름입니다.\n", month);
				break;
			case 9:
			case 10:
			case 11:
				System.out.printf("swich: %d월은 가을입니다.\n", month);
				break;
			case 12:
			case 1:
			case 2:
				System.out.printf("swich: %d월은 겨울입니다.\n", month);
				break;
		}

		if (month >= 1 && month <= 12) {
			if (month >= 3 && month <= 5) {
				System.out.printf("if: %d월은 봄입니다.\n", month);
			} else if (month >= 6 && month <= 8) {
				System.out.printf("if: %d월은 여름입니다.\n", month);
			} else if (month >= 9 && month <= 11) {
				System.out.printf("if: %d월은 여름입니다.\n", month);
			} else {
				System.out.printf("if: %d월은 겨울입니다.\n", month);
			}
		}

		// 문자열
		m = sc.next();

		switch (m) {

			case "3월":
			case "4월":
			case "5월":
				System.out.printf("swich: %s은 봄입니다.\n", m);
				break;
			case "6월":
			case "7월":
			case "8월":
				System.out.printf("swich: %s은 여름입니다.\n", m);
				break;
			case "9월":
			case "10월":
			case "11월":
				System.out.printf("swich: %s은 가을입니다.\n", m);
				break;
			case "12월":
			case "1월":
			case "2월":
				System.out.printf("swich: %s은 겨울입니다.\n", m);
				break;

		}

		if (m.equals("3월") || m.equals("4월") || m.equals("5월")) {
			System.out.printf("if: %s은 봄입니다.\n", m);
		}
		if (m.equals("6월") || m.equals("7월") || m.equals("8월")) {
			System.out.printf("if: %s은 여름입니다.\n", m);
		}
		if (m.equals("9월") || m.equals("10월") || m.equals("11월")) {
			System.out.printf("if: %s은 가을입니다.\n", m);
		}
		if (m.equals("12월") || m.equals("1월") || m.equals("2월")) {
			System.out.printf("if: %s은 겨울입니다.\n", m);
		}

	}

}
