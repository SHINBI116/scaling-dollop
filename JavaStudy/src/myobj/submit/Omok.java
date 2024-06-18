package myobj.submit;

import java.util.Scanner;

public class Omok {
	
	
	final static char[] OMOK_CHARS = {'┼', '┌', '┬','┐', '├', '┤', '└', '┴', 
			'┘', '╋','●', '○'};
	final public static int BLACK_STONE = 10;
	final public static int WHITE_STONE = 11;
	
	final public static int BOARD_WIDTH = 15;
	final public static int BOARD_HEIGHT = 15;
	
	int[][] board;
	
	public Omok() {
		board = new int[][] {
			{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5},
			{6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8},
		};
	}
	
	public static int getBlackStone() {
		return BLACK_STONE;
	}
	
	public static int getWhiteStone() {
		return WHITE_STONE;
	}
	
	public void printBoard() {
		
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[i].length; ++j) {
				System.out.printf("%2c", OMOK_CHARS[board[i][j]]);
			}
			System.out.println();
		}
	}
	public void preCheck(int x, int y, int stone) {
		return;
	}
	
	
	private boolean boardWidthCheck(int x, int y, int stone) {
		int count = 0;
		// 방금 놓은 위치로부터 가로 오른쪽으로 가면서 같은 색상의 돌의 개수를 센다
		for (int i = x; i < BOARD_WIDTH; ++i) {
			if (board[y][i]  == stone) {
				++count;
				//System.out.printf("더하기 가로 비교 board[%d][%d](%d)\n", y, i, count);
			} else {
				break;
			}
		}
		
		// 왼쪽 (방금 놓은 위치 미포함)
		for (int i = x - 1; i >= 0; --i) {
			if (board[y][i] == stone) {
				++count;
				//System.out.printf("빼기 가로 비교 board[%d][%d] (%d)\n", y, i, count);
			} else {
				break;
			}
		}
		if (count == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean boardHeightCheck(int x, int y, int stone) {
		int count = 0;
		// 세로로 연속으로 놓여있는 돌의 개수를 세기
		for (int i = y; i < BOARD_HEIGHT; ++i) {
			if (board[i][x] == stone) {
				++count;
				//System.out.printf("+세로 비교 board[%d][%d] (%d)\n", i, x, count);
			} else {
				break;
			}
		}
		for (int i = y - 1; i >= 0; --i) {
			if (board[i][x] == stone) {
				++count;
				//System.out.printf("-세로 비교 board[%d][%d] (%d)\n", i, x, count);
			} else {
				break;
			}
		}
		
		if (count == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean boardAscDiagonalCheck(int x, int y, int stone) {
		// | x - y | == b
					// x - y == b or y - x == b
					// y = x + b  or y = x + b

		int count = 0;
		int b = x > y ? x - y : y - x;
		for (int i = x; i < BOARD_HEIGHT; i++) {
						
			int j = i + b;
									
			if (j >= BOARD_WIDTH || j < 0) {
				break;
			}
			if (board[j][i] == stone) {
				++count;			
				//System.out.printf("더하기 x - y 비교 :board[%d][%d] (%d)\n", j, i, count);
			} else {
				break;
			}
		}
		for (int i = x - 1; i >= 0; i--) {
			int j = i + b;
								
			if (j >= BOARD_WIDTH || j < 0) {
				break;
			}
			if (board[j][i] == stone) {
				++count;			
				//System.out.printf("빼기 x - y 비교 :board[%d][%d] (%d)\n", j, i, count);
			} else {
				break;
			}
		}
		
		if (count == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean boardDescDiagonalCheck(int x, int y, int stone) {
		// x + y  ==  b
		int count = 0;
		int b = x + y;	
		int j;
		for (int i = x; i < BOARD_HEIGHT; i++) {
			j = b - i;
			if (j < 0 || j >= BOARD_WIDTH) {
				break;
			}					
			if (board[j][i] == stone) {
				++count;			
				//System.out.printf("더하기 x + y 비교 : board[%d][%d] (%d)\n", j, i, count);
			} else {
				break;
			}
		}
		for (int i = x - 1; i >= 0; i--) {
			j = b - i;
			if (j < 0 || j >= BOARD_WIDTH) {
				break;
			}					
			if (board[j][i] == stone) {
				++count;			
				//System.out.printf("빼기 x + y 비교 : board[%d][%d] (%d)\n", j, i, count);
			} else {
				break;
			}
		}
		if (count == 5) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	// 놓은 후에 진행하는 체크 ( 승리 여부)
		public int postCheck(int x, int y, int stone) {
			// 가로로 연속으로 놓여있는 돌의 개수를 세기
			boolean check = false;
			check |= boardWidthCheck(x, y, stone);
			if (check) {
				return 1;
			}
			
			//System.out.println("-----------------가로 비교---------------");
			check |= boardHeightCheck(x, y, stone);
			if (check) {
				return 1;
			}
			
			//System.out.println("----------------세로비교------------------");
			check |= boardAscDiagonalCheck(x, y, stone);
			if (check) {
				return 1;
			}
			
			//System.out.println("-------------------X - Y--------------");			

			check |= boardDescDiagonalCheck(x, y, stone);				
			if (check) {
				return 1;
			}
				
			//System.out.println("-------------------X + Y--------------");			
			
			return 0;
		}
		
		
	
	
	public boolean putBlack(int x, int y) {
		return putStone(x, y, BLACK_STONE);
	}
	
	public boolean putWhite(int x, int y) {
		return putStone(x, y, WHITE_STONE);
	}
	
	private boolean putStone(int x, int y, int stone) {
		if (x >= BOARD_WIDTH || x < 0 || y >= BOARD_HEIGHT || y < 0) {
			System.out.printf("[SYSTEM] 그곳은 놓을 수 없는 위치입니다. (%d, %d)\n", x, y);
			return false;
		}
		
		int v = board[y][x];
		
		if (v != BLACK_STONE && v != WHITE_STONE) {
			board[y][x] = stone;
			return true;
		} else {
			System.out.printf("[SYSTEM] 그곳은 이미 돌이 놓여있는 위치입니다. (%d, %d)\n", x, y);
			return false;
		}
	}
	
	
	static class Omok_Console {
		Omok omok = new Omok();
		Scanner sc= new Scanner(System.in);
		public Omok_Console() {
			omok.printBoard();
		}
		
		public void gameStart() {
			int turn = 0;
			int x, y;
			boolean result;
			while (true) {
				int currStone = whoTurn(turn);
				String stone_color = getStoneColor(currStone);
				
				System.out.printf("(%d턴) %s 돌을 놓아주세요 > ", turn + 1, stone_color);
				x = sc.nextInt();
				y = sc.nextInt();
				result = omok.putStone(x, y, currStone);
				
				if (result) {
					++turn;
				}
				
				omok.printBoard();
				
				int check = omok.postCheck(x, y, currStone);
				
				if (whoWin(check)) {
					System.out.printf("%s 돌의 승리입니다.", stone_color);
					break;
				}

			}
		}
		
		private int whoTurn(int turn) {
			if (turn % 2 == 0) {
				return Omok.getBlackStone();
			} else {
				return Omok.getWhiteStone();
			}
		}
		
		private boolean whoWin(int postCheck) {
			if (postCheck == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		private String getStoneColor(int stone) {
			if (stone == Omok.getBlackStone()) {
				return "검은색";
			} else {
				return "흰색";
			}
		}

	}
	
	public static void main(String[] args) {
		Omok_Console game = new Omok_Console();
		
		game.gameStart();
		
	}
	
	
}
