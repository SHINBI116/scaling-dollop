package quiz;

public class B08_ChangeCaseAns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String text = "I Like To Try Apple";
		
		int len = text.length();
		// int diff = Math.abs('A' - 'a');
		for (int i = 0; i < len; ++i) {
			char ch = text.charAt(i);
			
			if (ch >= 'a' && ch <= 'z') {
				System.out.print((char)(ch - 'a' + 'A'));
				//System.out.print((char)(ch - diff));
			} else if (ch >= 'A' && ch <= 'Z') {
				System.out.print((char)(ch - 'A' + 'a'));
				//System.out.print((char)(ch + diff));
	
			} else {
				System.out.print(ch);
			}
		}

	}

}
