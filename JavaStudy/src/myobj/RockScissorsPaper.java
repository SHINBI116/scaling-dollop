package myobj;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RockScissorsPaper {
	
	final static String[] ROCKSICSSORSPAPER = {"가위", "바위", "보"};
	//final static int[] GAME_VALUE = {-1, 0, 1};
	RockScissor_Score score = new RockScissor_Score();
	
	private String cpuResult() {
		int ran = (int)(Math.random() * ROCKSICSSORSPAPER.length);
		
		return ROCKSICSSORSPAPER[ran];
	}
	
	// 0 무승부 -1 짐 -2 유효하지않은 값 1 승리
	private int victory(String str1, String str2) {
		if (str1.equals(str2)) {
			return 0;
		}
		if (str1.equals("가위")) {
			if (str2.equals("바위")) {
				return -1;
			} else {
				return 1;
			}
		} else if (str1.equals("바위")) {
			if (str2.equals("보")) {
				return -1;
			} else {
				return 1;
			}
		} else if (str1.equals("보")) {
			if (str2.equals("가위")) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return -2;
		}
	}
	
	public void game() {
		Scanner sc = new Scanner(System.in);
		try (
				FileInputStream fin = new FileInputStream("myfiles/game_result.txt");
				DataInputStream din = new DataInputStream(fin);
			) {
				String result = din.readUTF();
				//System.out.println("지난승률 : (" + result + ")");
				
			} catch (FileNotFoundException e) {
				 e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		System.out.println("가위바위보 입력 > ");
		String result = sc.next();
		sc.nextLine();
		String cpu_result = cpuResult();
		
		int victory = victory(result, cpu_result);
		
		System.out.printf("%s vs %s\n", result, cpu_result);

		switch (victory) {
			case 0:
				System.out.println("무승부");
				score.plusDraw();
				break;
			case 1 :
				System.out.println("사용자의 승리");
				score.plusUserVictory();
				break;
			case -1 :
				System.out.println("사용자의 패배");
				score.plusUserDefeat();
				break;
			case -2 : 
				System.out.println("유효하지 않은값입니다.");
				break;
		}
		System.out.println(score);
		
		
	}
	public void stopGame() {
		
		try (
			FileOutputStream fout = new FileOutputStream("myfiles/game_result.txt");
			DataOutputStream dout = new DataOutputStream(fout);
		) {
			dout.writeUTF(score.toString());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

	
}
class isNotAvailableText extends Exception {
	public isNotAvailableText() {
		super("유효하지 않은 문자열입니다");
	}
}

