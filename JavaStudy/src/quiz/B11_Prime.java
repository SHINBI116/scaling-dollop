package quiz;

import java.util.Scanner;

/*
 	사용자가 정수를 입력하면 1부터 입력한 숫자 사이에 존재하는 모든 소수를 출력해보세요
 	
 	※ 소수(prime) : 약수가 1과 자기 자신밖에 없는 수 (2,3,5,7,11,13 ...)
 */

public class B11_Prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int num = sc.nextInt();
		int i = 1,j = 2;
		int cnt = 0;
		while (i <= num) {
			while (j <= i) {
				if ( i % j == 0) {
					cnt++;
				}
				++j;
			}
			if (cnt == 1) {
				System.out.printf("%d ",i);
			}
			cnt = 0;
			j = 2;
			++i;
		}
		
		System.out.println();
		
		for (int checkNum = 2; checkNum <= num; ++checkNum) {
			int yaksuCount = 0;
			for (int divider = 2; divider < checkNum; ++divider) {
				if (checkNum != divider && checkNum % divider == 0) {
					++yaksuCount;
					break;
				}
			}
			if (yaksuCount == 0) {
				System.out.println(checkNum);
			}

		}
		
		
		
		
		
	}
	
}
