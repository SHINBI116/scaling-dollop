package quiz;

public class B04_AppleQuiz {

	/*
	 * 사과를 10개씩 담을 수 있는 바구니가 있다. 사용자가 사과의 개수를 입력하면 사과를 모두 담기 위해 필요한 바구니의 개수를 알려주는
	 * 프로그램을 만들어보세요.
	 * 
	 */

	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		int qty,bucket_size,bucket_num;
		
		bucket_size = 10;
		
		System.out.println("사과 개수 입력: ");
		qty = sc.nextInt();
		
		if (qty < 0) {
			bucket_num = -1;
		} else {
			if (qty % bucket_size != 0) {
				bucket_num = qty/bucket_size+1;
			} else {
				bucket_num = qty/bucket_size;
			}
		}
		
		if (bucket_num == -1) {
			System.out.println("오류");
		} else {
			System.out.printf("%d개는 바구니 %d개 필요",qty,bucket_num);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

//		java.util.Scanner sc = new java.util.Scanner(System.in);
//
//		System.out.printf("사과 개수 입력 > ");
//
//		int apple = sc.nextInt();
//		int bucket;
//
//		if (apple >= 0) {
//			if (apple % 10 != 0) {
//				bucket = apple / 10 + 1;
//			} else {
//				bucket = apple / 10;
//			}
//
//			System.out.printf("바구니의 개수는 %d개 입니다", bucket);
//
//		} else {
//			System.out.println("사과 개수가 음수입니다.");
//		} 
		
		//ctrl shift f : 띄어쓰기 칸 맞추기

	}
	
	

}
