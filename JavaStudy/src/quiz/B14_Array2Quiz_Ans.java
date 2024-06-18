package quiz;

public class B14_Array2Quiz_Ans {

	public static void main(String[] args) {
		int[][] myArr = {
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0}
		};
		
		//1.
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				myArr[i][j] = (int )(Math.random() * 101) +100;
			}
		}
		
		//2.
		int sum = 0;
		double count = 0;
		for (int i = 0; i < myArr.length; ++i) {
			count += myArr[i].length;
			for (int j = 0; j < myArr[i].length; ++j) {
				sum += myArr[i][j];
			}
		}
		System.out.printf("총합 : %d, 평균 : %.2f\n", sum, sum / count);
		
		//3.
		int[] rowSum = new int[myArr.length];
		
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
					rowSum[i] += myArr[i][j];
			}
		}
		for (int i =0; i < rowSum.length; ++i) {
			System.out.printf("%d행의 합: %d\n", i, rowSum[i]);
		}
		
		//4.
		int maxColumnSize = 0;
		for (int i = 0; i < myArr.length; ++i) {
			maxColumnSize = maxColumnSize < myArr[i].length ?
					myArr[i].length : maxColumnSize;
		}
		// 열의 합의 개수는 가장 열이 많은 행의 길이가 된다
		int[] colSum = new int[maxColumnSize];
		
		for (int i = 0; i < myArr.length; ++i) {
			for (int j = 0; j < myArr[i].length; ++j) {
				colSum[j] += myArr[i][j];
			}
		}
		
		for (int i = 0; i < colSum.length; ++i) {
			System.out.printf("%d열의 합 : %d\n", i, colSum[i]);
		}
		
		for (int i = 0; i < myArr.length; ++i) {
			System.out.print("{");
			for (int j = 0; j < myArr[i].length; ++j) {
				System.out.printf("%03d, ", myArr[i][j]);
			}
			System.out.println("}");
		}
		
	}

}
