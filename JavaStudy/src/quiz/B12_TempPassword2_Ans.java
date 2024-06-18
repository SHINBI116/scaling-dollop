package quiz;

public class B12_TempPassword2_Ans {

	public static void main(String[] args) {
		String charset = "ABCDEFGHIJKMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
				+"0123456789!\"#$%&'()*+,-./";
		for (int i = 0; i < 20; ++i) {
			String password = "";
			
			for (int keyLen = 0; keyLen < 6; ++keyLen) {
				int randomIndex = (int)(Math.random() * charset.length());
				password += charset.charAt(randomIndex);
			}
			System.out.println(password);
		}
		
//		for (int i = 0; i < 20; ++i) {
//			String password = "";
//			for (int keyLen = 0; keyLen < 6; ++keyLen) {
//				int select = (int)(Math.random() * 4);
//				
//				if (select == 0) {
//						password += (char)(Math.random() * 26 + 'A');
//				} else if (select == 1) {
//						password += (char)(Math.random() * 26 + 'a');
//				} else if (select == 2) {
//						password += (char)(Math.random() * 15 + 33);
//				} else if (select == 3) {
//						password += (char)(Math.random() * 10 + '0');
//				}
//				
//	
//			}
//			System.out.println(i + "번째 비밀번호: " + password);
//		}
	}

}
