package myobj;

public class Language_patch {
	static String language = "Korean";
	
	public static void change_language(String language) {
		Language_patch.language = language;
	}
	
	public static void startMessage() {
		if (language.equals("Korean")) {
			System.out.println("안녕하세요");
		} else {
			System.out.println("Hello");
		}
	}
	
}
