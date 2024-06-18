package quizt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GuGuDan {

	public void writeFileGuGudan () {
		FileWriter out = null;
		
		try {
			out = new FileWriter("myfiles/gugudan.txt");
			for (int i = 2; i <= 9; ++i) {
				for (int j = 1; j <= 9; ++j) {
					int result = i * j;
					String gugudan = String.format("%d * %d = %2d\s", i, j, result);
					out.append(gugudan);
				}
				out.append("\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {			
				try {
					if (out != null) {
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	public void readFileGuGudan() {
		FileReader in = null;
		try {
			in = new FileReader("myfiles/gugudan.txt");
			int ch;
			while ((ch = in.read()) != -1) {
				System.out.print((char)ch);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	
	public static void main(String[] args) {
		GuGuDan g = new GuGuDan();
		g.writeFileGuGudan();
		g.readFileGuGudan();
	}
		

}
	

