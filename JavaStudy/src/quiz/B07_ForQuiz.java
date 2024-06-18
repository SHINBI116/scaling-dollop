package quiz;

public class B07_ForQuiz {
	/*
	 	1. 1000 ~ 2000 사이의 13의 배수를 모두 출력
	 	2. 50부터 100까지 모든 숫자의 총합을 구해서 출력
	 	3. 1부터 1000 사이의 모든 10의 배수를 한 줄에 8개씩 출력해보세요.
	 	4. 1부터 19까지의 모든 숫자의 곱을 구해서 출력
	 	5. 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력
    */

	public static void main(String[] args) {
		
		//1.
		System.out.print("13의 배수: ");
		for (int i = 1000; i <= 2000; ++i) {
			if (i %13 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		//2.
		int total = 0;
		for (int i = 50; i <= 100 ; i += 1) {
			total += i;
		}
		System.out.println("총합: " + total);
		
		//3.
		for (int i = 1; i <= 1000; ++i) {
			if (i % 10 == 0) {
					System.out.printf("%5d",i);
					if (i % 80 == 0) {
						System.out.println();
					}
			}
		}
		System.out.println();
		
		//4. 1부터 19까지의 모든 숫자의 곱을 구해서 출력
		
		long multy = 1;
		for (int i = 1; i <= 19; ++i) {
			multy *= i;
		}
		System.out.printf("1~19 곱한 결과: %d\n",multy);
		
		
		//5. 8999 ~ 4999 사이에 있는 5번째 287의 배수를 출력
		for (int i = 8999,count = 0; i >= 4999; --i) {
		if (i % 287 == 0) {
				++count;
				System.out.printf("i: %d count: %d\n",i,count);
			if (count == 5) {
				System.out.printf("위에서 %d번째 287의 배수는 %d\n",count,i);
				break;
			}
		}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		



		
		
		
	}

}
