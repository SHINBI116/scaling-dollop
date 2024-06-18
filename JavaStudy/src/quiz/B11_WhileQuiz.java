package quiz;

public class B11_WhileQuiz {
	/*
	while문을 사용하여
 	1. 1000 ~ 2000 사이의 13의 배수를 모두 출력
 	2. 50부터 100까지 모든 숫자의 총합을 구해서 출력
 	3. 1부터 1000 사이의 모든 10의 배수를 한 줄에 8개씩 출력해보세요.
 	4. 1부터 19까지의 모든 숫자의 곱을 구해서 출력
 	5. 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력
*/

	public static void main(String[] args) {
		
		//1.
		int i = 1000;
		System.out.print("13의 배수: ");
		while (i >= 1000 && i <= 2000) {
			if (i % 13 == 0) {
				System.out.print(i + " ");
			}
			i++;			
		}
		System.out.println();
		
		//2.
		int j = 50;
		int total = 0;
		while (j >= 50 && j <= 100) {
			total += j;
			j++;
		}
		System.out.println("50 ~ 100 총합 : " + total);

		//3.
		int k = 1;
		int cnt = 0;
		while (k >= 1 && k <= 1000) {
			if (k % 10 == 0) {
				System.out.printf("%5d",k);
				if (++cnt % 8 == 0) {
					System.out.println();
				}
			}
			k++;
		}
		System.out.println();
		
		//4. 1부터 19까지의 모든 숫자의 곱을 구해서 출력
		
		int l = 1;
		long total2 = 1;
		while (l >= 1 && l <= 19) {
			total2 *= l;
			l++;
		}
		System.out.printf("1 ~ 19까지 곱 : %d\n",total2);
		
		//5. 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력
		
		int m = 8999;
		int cnt2 = 0;
		while (m >= 4999 && m <= 8999) {
			if (m % 287 == 0) {
				if (++cnt2 == 5) {
					System.out.printf("%d번째 287배수 : %d",cnt2,m);
				}
			}
			m--;
		}
		
		
		
		
		
		
	}
		
		
}


