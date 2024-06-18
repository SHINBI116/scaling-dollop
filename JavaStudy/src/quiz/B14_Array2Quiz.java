package quiz;

public class B14_Array2Quiz {

	public static void main(String[] args) {
		
		int[][] myArr = {
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0}
		};
		
		
		boolean DEBUG_MODE = true;
		
		// 1. myArr의 모든 값을 100 ~ 200 사이의 랜덤 정수로 바꾸기
		
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				int ran = (int)(Math.random() * 101 ) + 100;
				myArr[i][j] = ran;
			}
			
		}
		if (DEBUG_MODE) {
			System.out.println("* myArr *");
			for (int i = 0; i < myArr.length; ++i) {
				for (int j = 0; j < myArr[i].length; ++j) {
					System.out.printf("[%d][%d] : %d\n", i, j, myArr[i][j]);
				}
				
			}
		}
		
		
		// 2. 랜덤으로 바뀐 모든 값의 총합과 평균을 구하기
		int total = 0;
		double avg;
		int avg_len = 0; 
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				total += myArr[i][j];
			}
			avg_len += myArr[i].length;
		}
		
		avg = total / (double) avg_len;
		
		System.out.println("총합은 " + total + " 평균은 " + avg);
		
		
		// 3. 각 행(row)의 합을 구해서 출력하기
		
		
		for (int i = 0; i < myArr.length; ++i) {
			int row_total = 0;
			for (int j = 0; j < myArr[i].length; ++j) {
				row_total += myArr[i][j];
			}
			System.out.printf("%d행의 총합은 %d\n", i, row_total);
		}
		System.out.println();
		
		// 4. 각 열(col)의 합을 구해서 출력하기
		// 0열+ 00 10 20 30 40 1열+ 01 11 21 31 41 2열+ 02 12 22 32 42 3열+ 03 13 23(에러) 33 43 ......
		
		int myArr2[][] = new int [5][10];
		
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				myArr2[i][j] = myArr[i][j];
			}
		}
		
		if (!DEBUG_MODE) {
			System.out.println("* myArr2 *");
			for (int i = 0; i < myArr2.length; ++i) {
				for (int j = 0; j < myArr2[i].length; ++j) {
					System.out.printf("[%d][%d] : %d\n", i, j, myArr2[i][j]);
				}
				
			}
		}
	
		for (int i = 0; i < 10; ++i) {
			int col_total = 0;
			for (int j = 0; j < myArr2.length; ++j) {
				col_total += myArr2[j][i];
				
			}
			System.out.printf("%d열의 총합은 %d\n", i, col_total);
		}
		
		System.out.println();

	}

}
