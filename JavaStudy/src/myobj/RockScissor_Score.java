package myobj;

public class RockScissor_Score {
	int userVictory;
	int userDefeat;
	int draw;
	
	

	public int getUserDefeat() {
		return userDefeat;
	}
	public int getUserVictory() {
		return userVictory;
	}
	public int getDraw() {
		return draw;
	}
	public int plusUserDefeat() {
		return ++userDefeat;
	}

	public int plusUserVictory() {
		return ++userVictory;
	}
	
	public int plusDraw() {
		return ++draw;
	}
	
	@Override
	public String toString() {
		return String.format("사용자 : %d승%d패%d무",
				userVictory, userDefeat, draw);
	}
	
}
