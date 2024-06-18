package myobj;

public class Omok_player {
	char stone;
	Omok game = new Omok();
	public Omok_player(char stone) {
		this.stone = stone;
	}
	

	public void setStone(int x, int y) {
		game.omok[x][y] = stone;
		game.printPan();
		
	}
	
	public int widthWin(int x) {
		int count = 0;
		for (int i = 0; i < game.omok.length; ++i) {
			if (game.omok[x][i] == stone) {
				++count;
			}
		}
		return count;
	}
	
	public int heightWin(int y) {
		int count = 0;
		for (int i = 0; i < game.omok.length; ++i) {
			if (game.omok[i][y] == stone) {
				++count;
			}
		}
		return count;
	}
	
	public int diagWin(int x, int y) {
		int count = 0;
		
		
		return count;
	}
}
