
public class C09_AccessModifier extends myobj.C09_AccessModifierTest {
	
	// 다른 패키지의 클래스를 상속받으면 public과 protected까지 사용할 수 있다
	public C09_AccessModifier() {
		int num;
		
		num = super.a;
		num = super.a2;
		
		super.method1();
		super.method2();
	}
	/*
	 	# 접근 제어자 (Access Modifier)
	 	
	 	- 다른 클래스에서 해당 자원을 사용하려고 할 때 허용 범위를 설정한다
	 	
	 	# 접근 제어자의 종류
	 	
	 	- public 	: 다른 패키지의 다른 클래스에서 해당 자원에 접근할 수 있다
	 				  당연히 같은 패키지의 다른 클래스에서도 접근할 수 있다
	 	- protected : 다른 패키지의 다른 클래스에서 해당 클래스를 상속받는 경우에는 접근할 수 있다
	 				  일반적으로 사용하는 경우, 다른 패키지에서는 접근할 수 없다
	 				  같은 패키지의 다른 클래스에서는 접근할 수 있다.
	 	- default	: 다른 패키지에서 접근할 수 없다
	 				  같은 패키지의 다른 클래스에서는 접근할 수 있다
	 	- private	: 다른 패키지에서 접근할 수 없다
	 				  심지어 같은 패키지의 다른 클래스에서도 접근 할 수 없다
	 				  현재 클래스 내부에서만 사용할 수 있는 자원이 된다
	 */
	public static void main(String[] args) {
		
		for (int i = 0; i < args.length; ++i) {
			System.out.println("args? " + args[i]);
		}
		// 현쟈 같은 패키지내에 존재하는 다른  클래스를 불러 사용하는 경우
		// (private을 제외하고 모두 사용할 수 있다)
		C09_AccessModifierTest test1 = new C09_AccessModifierTest();
		
		int num;
		
		num = test1.a; // public 
		num = test1.a2;// protected
		num = test1.a3;// default
		
		test1.method1();// public 
		test1.method2();// protected
		test1.method3();// default
		
		// 다른 패키지에 존재하는 클래스를 불러 사용하는 경우
		// (public만 쓸 수 있다)
		myobj.C09_AccessModifierTest test2 = 
				new myobj.C09_AccessModifierTest();
		
		num = test2.a; // public 
		
		test2.method1(); // public 
	}
}
