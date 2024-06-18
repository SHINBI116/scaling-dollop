package quizt;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Socket s = new Socket("118.235.0.1", 9011);
			
			try (
				PrintStream out  = new PrintStream(s.getOutputStream());
				BufferedInputStream in = new BufferedInputStream(s.getInputStream());
			) {
				System.out.println(in.readAllBytes());
				while (true) {
					System.out.println(">");
					out.println(sc.nextLine());
				}
				
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}