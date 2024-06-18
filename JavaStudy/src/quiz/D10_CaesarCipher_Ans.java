package quiz;

import javax.crypto.Cipher;

public class D10_CaesarCipher_Ans {
	
	String cryptSet;
	
	public D10_CaesarCipher_Ans() {
		cryptSet = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789!@#$%^&*()-_=+"
				+ "abcdefghijklmnopqrsuvwxyz {}[]|\\;:'\"/?<>,.";
	}
	
	public D10_CaesarCipher_Ans(String cryptSet) {
		this.cryptSet = cryptSet;
	}
	
	String encrypt(String plain, int key) {
		StringBuilder result = new StringBuilder();
		
		int len = plain.length();
		
		// 문자를 하나씩 꺼낸다
		for (int i = 0; i < len; ++i) {
			char ch = plain.charAt(i);
			
			// 암호표에서 해당 문자의 위치를 찾는다
			int index = cryptSet.indexOf(ch);
			
			// 만약 -1이 나왔다면 암호표에 존재하지 않는 문자이므로 그대로 유지
			// index가 -1이 아니라면 암호표에서 키값만큼 더한 문자를 가져와서 추가
			if (index != -1) {
				result.append(cryptSet.charAt((index + key) % cryptSet.length()));
			} else {
				result.append(ch);
			}
		}
		
		return result.toString();
	}
	
	String decrypt(String crypto, int key) {
		StringBuilder result = new StringBuilder();
		
		int len = crypto.length();
		int len2 = cryptSet.length();
		
		// key = key % len2; // 어차피 키값이 너무 커봤자 의미가 없는 알고리즘이기 때문에 사이즈를 줄일 수 있다
		for (int i = 0; i < len; ++i) {
			char ch = crypto.charAt(i);
			
			// ex "ABCEDFG"
			// 전체길이 : 7
			// 키 값은 7 이상이어봤자 의미가 없다
			int index = cryptSet.indexOf(ch);
			
			if (index != -1) {
				// 키값으로 뺏는데 결과가 음수인 경우와 양수인 경우를 처리한다
				int target = index - (key % len2);
				
				if (target < 0) {
					result.append(cryptSet.charAt(target + len2));
				} else {
					result.append(cryptSet.charAt(target));
				}
				
				//result.append(cryptSet.charAt(index - key + len2));
			} else {
				result.append(ch);
			}
			
		}
		
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		D10_CaesarCipher_Ans cipher1 = new D10_CaesarCipher_Ans();
		
		int key = 10;
		
		String encrypted = cipher1.encrypt("한글, abc, 123.", key);
		System.out.println("암호화 결과 : " + encrypted);
		
		String decrypted = cipher1.decrypt(encrypted, key);
		System.out.println("복호화 결과: " + decrypted);
	}
}
