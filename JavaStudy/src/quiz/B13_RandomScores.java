package quiz;

public class B13_RandomScores {
	/*
	 	1. 100개의 정수를 랜덤으로 생성하여 배열에 저장
	 		(점수는 0 ~ 100점)
	 	2. 배열에 저장된 값을 한 줄에 10개씩 출력
	 		(단, 60점 미만인 점수는 X로 표시)
	 	3. 모든 점수의 평균 점수를 출력 (쇼수 둘째 자리까지 출력)
	 	4. 생성된 랜덤 점수 중 가장 높은 점수와 가장 낮은 점수를 출력
	 	
	 	※ 모든 과정을 하나의 반복으로 처리하는 것은 금지
	 	
	 */
	
	public static void main(String[] args) {
		int[] scores = new int[100];
		//1.
		for (int i = 0; i < scores.length; ++i) {
			scores[i] = (int) (Math.random() * 101);
		}
		
		//2.
		for (int i = 0;i < scores.length; ++i) {
			if (scores[i] < 60) {
				System.out.print("X\t"); 
			} else {
				System.out.print(scores[i] + "\t");
			}
			
			if (i % 10 == 9) {
				System.out.println();
			}
		}
		
		//3.모든 점수의 평균 점수를 출력 (쇼수 둘째 자리까지 출력)
		int total = 0;
		for (int i = 0;i < scores.length; ++i) {
			total += scores[i];
		}
		System.out.printf("평균점수 : %.2f점\n", total / (double) scores.length);
		
		//4. 생성된 랜덤 점수 중 가장 높은 점수와 가장 낮은 점수를 출력
		int maxScore = 0;
		int minScore = 100;
		
		// 삼항연산자
		// 조건 ? 예 : 아니오;
		// ? 앞의 조건이 참일때는 :의 왼쪽값을 선택
		// ? 앞의 조건이 거짓일때는 :의 오른쪽값을 선택
		for (int i = 0; i < scores.length; ++i) {
			
			maxScore = maxScore > scores[i] ? maxScore : scores[i];
			minScore = minScore < scores[i] ? minScore : scores[i];
			
			//maxScore = Math.max(maxScore, scores[i]);
			//minScore = Math.min(minScore, scores[i]);
			
//			 현재 최고값과 i번째 값을 비교해서 i번째 값이 더 크면 최고값으로 변경한다
//			if (maxScore < scores[i]) {
//				maxScore = scores[i];
//			}
// 			현재 최저값과 i번째 값을 비교해서 i번째 값이 더 작으면 최저값으로 변경한다
//			if (minScore > scores[i] ) {
//				minScore = scores[i];
//			}
		}
		System.out.printf("최고점수: %d 최저점수 : %d", maxScore, minScore);
	}

}
