package quiz;

import java.util.Scanner;

import myobj.omok.Omok;

public class D08_Omok {
	// 오목을 만들어 주세요
	
		public static void main(String[] args) {
			Omok omok = new Omok();
			Scanner sc= new Scanner(System.in);
			
			int turn = 0;
			while (true) {
				omok.printBoard();
				
				
				int x, y;
				if (turn % 2 == 0) {
					System.out.printf("(%d턴)검은돌 좌표 입력 > ", turn + 1);
					x = sc.nextInt();
					y = sc.nextInt();
					boolean result = omok.putBlack(x, y);
					if (result) {
						++turn;
					}
				} else {
					System.out.printf("(%d턴)흰돌 좌표 입력 > ", turn + 1);
					x = sc.nextInt();
					y = sc.nextInt();
					boolean result = omok.putWhite(x, y);
					if (result) {
						++turn;
					}
				}
				

				
				if (omok.postCheck(x, y, omok.BLACK_STONE) == 1) {
					omok.printBoard();
					System.out.println("검은돌 승리!");
					break;
				}
				if (omok.postCheck(x, y, omok.WHITE_STONE) == 1) {
					omok.printBoard();
					System.out.println("흰돌 승리!");
					break;
				}
			}
			
			
//			omok.putBlack(7, 7);
//			omok.putBlack(2, 7);
//			omok.putBlack(5, 7);
//			omok.putBlack(10, 7);
//			omok.putBlack(8, 7);
			
//			omok.putBlack(2, 1);
//			omok.putBlack(3, 2);
//			omok.putBlack(4, 3);
//			omok.putBlack(5, 4);
//			omok.putBlack(7, 5);
//			//omok.putBlack(3, 7);
//			
//			System.out.println(omok.postCheck(7, 5, omok.BLACK_STONE));
//			
//			omok.printBoard();
			
			// Hint2 - 오목판에 돌 놓는 방법
//			char[][] omok = {
//					{'┌', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┬', '┐'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┤', '┤', '┤', '┤'},
//					{'├', '┼', '┼', '●', '○', '┼', '┼', '┼', '┼', '┼', '┤', '┤', '┤', '┤', '┤'},
//					{'├', '┼', '┼', '┼', '●', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┤', '┤'},
//					{'├', '┼', '┼', '┼', '┼', '●', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┤', '┤'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '○', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┤'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┤'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'├', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┼', '┤', '┼', '┼', '┼', '┼'},
//					{'└', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┴', '┘'},
//			};
//			
//			for (int i = 0; i < omok.length; ++i) {
//				for (int j = 0; j < omok[i].length; ++j) {
//					System.out.printf("%-2c", omok[i][j]);
//				}
//				System.out.println();
//			}
		}
}
