package quiz;

public class B07_ForQuiz2 {
	/*
	 	# for문을 사용해 숫자를 다음과 같이 출력해보세요
	 	
	 	1. 0 3 6 9 12 ... 93 96 99
	 	2. -35 -28 -21 ... 0 7 14 ... 35
	 	3. 100 200 300 ... 800 900 1000
	 	4. 100 99 98 ... 5 4 3 2 1 0
	 	5. 0 1 2 3 ... 6 7 8 9 0 1 2 3..7 8 9 .. (30번)
	 	6.10 9 8 7 .. 3 2 1 10 9 8 .. 3 2 1 10 9 ... (30번)
	 	7. 7 77 777 7777 77777 ... 7777777777
	 */
	
	public static void main(String[] args) {
		
		//1.
		System.out.println("1번");
		for (int i = 0; i <100; ++i) {
			if ( i % 3 == 0) {
				System.out.printf("%d ",i);
			}
		}
		System.out.println();
		
		//2.
		System.out.println("2번");
		for(int i = -35; i <= 35; ++i) {
			if (i % 7 == 0) {
				System.out.printf("%d ",i);
			}
		}
		System.out.println();
		
		//3.
		System.out.println("3번");
		for(int i = 100; i <= 1000; ++i) {
			if (i % 100 == 0) {
				System.out.printf("%d ",i);
			}
		}
		System.out.println();
		
		//4.
		System.out.println("4번");
		for(int i =100; i >= 0; --i) {
			System.out.printf("%d ",i);
		}
		System.out.println();
		
		//5. 0 1 2 3 ... 6 7 8 9 0 1 2 3..7 8 9 .. (30번)
		System.out.println("5번");
		for (int i = 0; i < 30; ++i) {
			for(int a = 0; a < 10; ++a) {
				System.out.printf("%d ",a);
			}
		}
		System.out.println();
		
		//6.10 9 8 7 .. 3 2 1 10 9 8 .. 3 2 1 10 9 ... (30번)
		System.out.println("6번");
		for (int i = 0; i < 30; ++i) {
			for(int a = 10; a >= 0; --a) {
				System.out.printf("%d ",a);
			}
		}
		System.out.println();
		
		//7. 7 77 777 7777 77777 ... 7777777777
		//a=10^0*7 a=10^1*7+a a=10^2*7+a(77) .....
		long seven = 0;
		double mul;
		System.out.println("7번");
		for (int i = 0 ; i < 10; ++i) {
			mul = Math.pow(10, i)*7;
			seven += mul;
			System.out.print(seven + " ");
			
			
		}
		System.out.println();
		
	
	
		
		 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
