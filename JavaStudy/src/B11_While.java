
public class B11_While {
	/*
	 	# while문
	 	
	 	- for문과 사용법이 약간 다른 반복문
	 	- 초기값과 증감값의 위치가 정해져 있지 않아 더 자유롭게 사용할 수 잇다
	 	- ()안의 내용이 true인 동안 {}의 내용을 계속 반복한다
	 	- 증감값의 위치에 따라 결과가 달라질 수 있으므로 주의해야 한다
	 */

	public static void main(String[] args) {
		
		//for (; true;) {}
		
		// 0 ~ 9로 10개
		int i = 0;
		while (i < 10) {
			System.out.println("Hello!" + i++);
		}
		
		i = 0;
		
		// 1 ~ 10까지 10개
		while (i < 10) {
			System.out.println("Hello" + ++i);
		}
		
		// 1 ~ 10까지 10개
		i = 0;
		// 비교후 증가 1 ~ 10
		while (i++ < 10) {
			System.out.println("Hello" + i);
		}
		
		i = 0;
		//10을 썼는데 1 ~ 9까지 9개가 나오므로 직관적이지 않아서 잘 쓰지 않음
		while (++i < 10) {
			System.out.println("Hello" + i);
		}
		
		
		
		
		
	}
	
}
