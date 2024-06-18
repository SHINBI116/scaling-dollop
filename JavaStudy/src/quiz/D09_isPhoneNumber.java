package quiz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D09_isPhoneNumber {
	/*
	 	전달받은 문자열이 올바른 핸드폰 번호인지 검사하는 메서드를 만들어보세요
	 */
	
	
	
	public static boolean isRightphone(String text) {
		String[] phoneNum = new String[3];
		
		if (text.contains("-")) {
			phoneNum = text.split("-");		
		} else {
			if (text.length() != 11) {
				return false;
			}
			phoneNum[0] = text.substring(0, 3);
			phoneNum[1] = text.substring(3, 7);
			phoneNum[2] = text.substring(7, 11);
		}
						
		if (!(phoneNum[0].equals("010"))) {
			return false;
		}
		if (phoneNum[1].length() != 4 || phoneNum[2].length() != 4) {
			return false;
		}
		
		for (int i = 1; i <= 2; ++i) {
			String textNum = phoneNum[i];
			for (int j = 0; j < phoneNum[i].length(); ++j) {
				char num = textNum.charAt(j);
				if (num < '0' || num > '9' ) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static boolean isRightphoneNum(String text) {
		String[] phoneNum;
		// 만약 10글자 숫자로만 된 문자열이 들어왔다면
		// -를 붙여준다...
		if (text.length() <= 11) {
			List<Character> ch = new LinkedList<>();
			for (int i = 0; i < text.length(); ++i) {
				 ch.add(i, text.charAt(i)); 
			}
			ch.add(3, '-');
			ch.add(8, '-');
			text = "";
			for (int i = 0; i < ch.size(); ++i) {
				text += ch.get(i);
			}
		}
		
		text = text.replace(" ", "");
		phoneNum = text.split("-");
		
		if (phoneNum.length != 3) {
			return false;
		}
		
		if (!(phoneNum[0].equals("010"))) {
			return false;
		} else {
			for (int i = 1; i < phoneNum.length; ++i) {
				if (phoneNum[i].length() != 4) {
					return false;
				}
			}
		}
		
		for (int i = 0; i < phoneNum.length; ++i) {
			for (int j = 0; j < phoneNum[i].length(); ++j) {
				char num = phoneNum[i].charAt(j);
				if (num < '0' || num > '9') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static boolean isValidPhoneNumber(String phoneNumber) {
		
		// 외곽의 공백은 허용해준다
		phoneNumber = phoneNumber.trim();
		
		// 1. 숫자와 -만으로 이루어진 문자열인가
		int len = phoneNumber.length();
		for (int i = 0; i < phoneNumber.length(); ++i) {
			char ch = phoneNumber.charAt(i);
			
			if (ch != '-' && (ch < '0' || ch > '9')) {
				System.out.println("[SYSTEM] - 또는 숫자가 아닙니다");
				return false;
			}
		}
		
		if (phoneNumber.contains("-")) {
			if (phoneNumber.length() != 13) {
				System.out.println("[SYSTEM] 번호의 길이가 잘못되었습니다.");
				return false;
			} else if (phoneNumber.indexOf('-') != 3 || phoneNumber.lastIndexOf('-') != 8) {
				System.out.println("[SYSTEM] -의 위치가 잘못되었습니다");
				return false;
			}
		}
		
		// 모든 -를 제거한 후 길이가 11인가
		phoneNumber = phoneNumber.replace("-", "");
		
		if (phoneNumber.length() != 11) {
			System.out.println("[SYSTEM] 숫자의 개수가 잘못되었습니다.");
			return false;
		}
		// 010으로 시작하는가
		if (!phoneNumber.startsWith("010")) {
			System.out.println("[SYSTEM] 번호가 010으로 시작하지 않습니다.");
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		String ph = "010-1234-1234";
		
		System.out.println(isValidPhoneNumber(ph));
	}
}
