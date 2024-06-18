package quizt;

public class MemberTest {
	static class Member {
		String userId;
		String name;
		int age;
		
		public Member() {
			this.name = "홍길동";
			this.userId = "user01";
			this.age = 100;
		}

		
		public int getAge() {
			return age;
		}
		public String getName() {
			return name;
		}
		public String getUserId() {
			return userId;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setUserId(String userId) {
			this.userId = userId;
		}
		
		@Override
		public String toString() {		
			return String.format("이름:%s 아이디:%s 나이:%d\n", name, userId, age);
		}
	}
	public static void main(String[] args) {
		Member test = new Member();
		
		
		System.out.println(test);
	}
}
