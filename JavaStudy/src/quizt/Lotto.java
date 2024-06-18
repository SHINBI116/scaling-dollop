package quizt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lotto {
	/*
 	(1) 1 ~ 45 사이의 중복없는 랜덤 숫자 7개를 생성하여 로또 당첨 번호를 만들어 보세요
 	
 		1. 숫자를 랜덤으로 뽑는다
 		2. 뽑았으면 이전에 뽑았던 숫자중에 방금뽑은숫자가 없는지 확인한다
 		3. 있으면 다시뽑고 없으면 넘어간다
 	
 	(2) 1등 또는 2등에 당첨될때까지 랜덤 로또 번호를 계속생성하여
 	 	몇 번 만에 당첨되었는지 출력해보세요
 	 	
 	 	- 로또 구매자는 번호를 6개 고른다
		- 보너스 번호를 제외하고 모두 맞추면 1등
		- 보너스 번호를 포함하여 모두 맞추면 2등
 */
	
	// 고칠것 당첨로직, 사용자 뽑은숫자가 ㅄ
	
	final static int USER_DRAW = 6;
	int[] win = new int[7];
	List<Integer> user = new ArrayList<>();
	int count = 0;
	
	int rank;
	boolean is2st;
	
	public Lotto() {
		draw();
	}
	
	private int ranValue() {
		return (int)(Math.random() * 45) + 1;
	}
	
	private void draw() {
		for (int i = 0; i < win.length; ++i) {
			win[i] = ranValue();
			for (int j = 0; j < i; ++j) {
				if (win[i] == win[j]) {
					--i;
					break;
				}
			}
		}
	}
	
	public void drawUntilWin(int num) {
		
		for (int i = 0; i < win.length ; ++i) {
			if (win[i] == num) {
				user.add(num);
				++count;
				if (i == 6) {
					is2st = true;
				}
				break;
			}
		}
		
	}
	
	public void start() {
		int draw_count = 1;
		while (true) {
			Lotto lotto = new Lotto();
			for (int i = 0; i < USER_DRAW; ++i) {
				drawUntilWin(ranValue());
			}
			++draw_count;
			if (isWin()) {
				System.out.println("뽑은 번호들: " + user);
				if (rank == 1) {					
					System.out.printf("%d회만에 1등당첨\n", draw_count);
				} else if (rank == 2) {
					System.out.printf("%d회만에 2등당첨\n", draw_count);
				}
				break;
			}
		}
	}
	
	// 1등이면 rank 1 2등 2
	private boolean isWin() {
		if (count == 6) {
			if (!is2st) {
				rank = 1;
			} else {
				rank = 2;
			}
			return true;
		} else {
			return false;
		}
		
	}
	
	
	public void showWin() {
		System.out.println("당첨번호: " + Arrays.toString(win));
	}
	
	
	public static void main(String[] args) {
		Lotto l = new Lotto();
		l.showWin();
		l.start();
	}
	
}
