package quiz;

import java.util.ArrayList;
import java.util.List;

public class D01_ArrayListQuiz {
	/*
	 	1. 리스트에 1000 ~ 1999 사이의 랜덤 정수를 100개 추가하기
	 	
	 	2. 원본에서 짝수를 모두 제거한 후 원본에 남아있는 값의 개수를 세기
	 	
	 	3. 원본에서 홀수를 모두 제거한 후 원본에 남아있는 값의 개수를 세기
	 */
	
	public static void arrPrint(List<Integer> arr) {
		int remainCount = arr.size();
		System.out.println("리스트 값 개수 : " + remainCount);
		System.out.println(arr);
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();

		//1.
		for (int i = 0; i < 100; ++i) {
			int ran = (int)(Math.random() * 1900) + 100;
			arr.add(ran);
		}		
		arrPrint(arr);
		
		//2.
		List<Integer> evenRemove = new ArrayList<>();
		for (int i = 0; i < arr.size(); ++i) {
			if (arr.get(i) % 2 == 0) {
				evenRemove.add(arr.get(i));
			}			
		}
		arr.removeAll(evenRemove);
		arrPrint(arr);
		
		//3.
		List<Integer> oddRemove = new ArrayList<>();
		for (int i = 0; i < arr.size(); ++i) {
			if (arr.get(i) % 2 != 0) {
				oddRemove.add(arr.get(i));
			}
		}
		arr.removeAll(oddRemove);
		arrPrint(arr);
		
	}
}
