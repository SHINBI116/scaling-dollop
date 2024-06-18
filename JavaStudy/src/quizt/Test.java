package quizt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Test {
	
	public static void main(String[] args) {
		
		
		String text = "";
		try (
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		) {
			Integer ch;
			char c;
			while ((ch = in.read()) != -1) {
				
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println(text);
		
	}
	
	

}


