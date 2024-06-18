package quiz;

public class B12_TempPasswordAns {

	public static void main(String[] args) {
		/*
		 	65 ~ 90 사이의 랜덤 숫자 4개
		 */
		for (int i = 0; i < 20; ++i) {
			String password = "";
			for (int keyLen = 0; keyLen < 4; ++keyLen) {
				password += (char)(Math.random() * 26 + 65);
			}
			System.out.println(i + "번째 비밀번호: " + password);
		}
	}

}
