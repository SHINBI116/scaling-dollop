package quiz;

public class A03_Typequiz {

	public static void main(String[] args) {
		
		String name="홍길동";
		System.out.println("이름 :"+name);
		int age = 20;// 자원을 아주 절약해야하는 상황이 아니라면 그냥 int 쓰는편
		System.out.println("나이 :"+age);
		String tel = "010-1234-1234";
		System.out.println("Tel	: "+tel);
		double height = 178.5;// 자원을 아주 절약해야하는 상황이 아니라면 그냥 double 쓰는편
		System.out.println("키	: "+height);
		int weight = 75;
		System.out.println("몸무게	: "+weight);
		//AB형은 char타입에 저장할 수 없으므로 String을 써야함
		String blood = "O";
		System.out.println("혈액형	: "+blood);
		

	}

}
