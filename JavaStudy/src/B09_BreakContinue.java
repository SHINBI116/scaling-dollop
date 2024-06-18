
public class B09_BreakContinue {
	/*
	   # break
	  
	   - switch-case문 내부에서 사용하면 해당 case를 탈출한다 
	   - 반복문 내부에서 사용하면 해당 반복문을 탈출한다
	  
	   # continue
	  
	  - 반복문 내부에서 continue를 만나면 즉시 다음번 반복으로 넘어간다
	 */

	public static void main(String[] args) {
		// break 위치에 따라 결과 다름
		for (int i = 0; i < 1000; ++i) {
			System.out.println(i);
			// i값이 323일때 break를 만나 반복문 탈출
			if (i == 323) {
				break;
			}
		}
		System.out.println("---------------------------------------------");
		// Ctrl + Shift + F : 자동 줄맞춤
		for (int i = 0; i < 100; ++i) {
			if (i % 2 == 0) {
				continue;
			}
			System.out.println(i);
			
		}

	}

}
