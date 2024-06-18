package quiz;

import java.util.Arrays;

import myobj.Fbread;

public class C04_CountFishBread {
	
	/*
	 	1. 붕어빵 클래스를 만들어보세요
	 	   -붕어빵의 속성은 맛, 가격, 품질이 있으며
	 	   -맛과 품질은 인스턴스 생성시 랜덤으로 결정됨
	 	   -가격은 팥 800원  슈크림 1000원 민초 1200원
	 	    품질에 따라 +-100원이 된다 (품질은 상/중/하)
	 	 
	 	2. 설계한 클래스를  활용하여 붕어빵을 100개 만들고
	 	   어떤 맛 붕어빵이 몇 개 있는지 세어보세요
	 	
	    3. n개의 붕어빵 배열을 전달하면 모든 붕어빵의 가격이 얼마인지 계산해주는
	       함수를 만들어보세요
	 	
	 */

	public static void main(String[] args) {
		// 붕어빵 100개 만들기
		Fbread[] breads = new Fbread[100];
		for (int i = 0; i < 100; ++i) {
			breads[i] = new Fbread();
		}
		
		// 붕어빵 맛 개수 세기
		int[] flavorCount = new int[Fbread.kindOfflavors];
		
		for (int i = 0; i < breads.length; ++i) {
			flavorCount[breads[i].flavor] += 1;
		}
		System.out.println(Arrays.toString(flavorCount));
		System.out.println("총 가격 : " + Fbread.getTotalPrice(breads));
	}

}
