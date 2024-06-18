package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class E10_FileEncryption {
	/*
	 	frankenstein.txt를 시저 암호방식으로 암호화한 새 파일
	 	frankenstein_encrypted.enc을 생성해보세요
	 	
	 	(1) char 단위로 한 글자씩 암호화하는 속도를 측정해보기
	 	
	 	(2) char[] 방식으로 암호화하는 속도를 측정해보기
	 	
	 	(3) Buffered 클래스를 붙여 암호화하는 속도를 측정해보기
		
		(4) 이미 같은 이름의 암호화 결과 파일이 경로에 존재한다면
			파일의 이름 뒤에 (숫자)를 붙여 다음 파일이 생기게 만들기
			
			frankenstein_encrypted(1).enc
			frankenstein_encrypted(2).enc
			frankenstein_encrypted(3).enc ..
	 */
	
	static String cryptSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+"
			+ "abcdefghijklmnopqrstuvwxyz {}[]|\\;:'\"/?<>,.";
	
	static File franken = new File("franken/frankenstein.txt");
	static File franken_encry = new File("franken/frankenstein_encrypted.enc");
	static ArrayList<File> duplication = new ArrayList<>();
	
	
	public static void encryptChar(int key) {
		
		try (
			FileReader in = new FileReader(franken);			
			FileWriter out = new FileWriter(franken_encry);
		) {
			FileWriter dup_out;
			alreadyExist(franken_encry);
			if (!(duplication.size() == 0)) {
				dup_out = new FileWriter(duplication.get(duplication.size() - 1));
				int ch;
				while ((ch = in.read()) != -1) {
					int index = cryptSet.indexOf(ch);
					
					if (index != -1) {
						dup_out.write(cryptSet.charAt((index + key) % cryptSet.length()));
						
					} else {
						dup_out.write(ch);
					}
				}
				
				dup_out.close();
			} else {
				int ch;
				while ((ch = in.read()) != -1) {
					int index = cryptSet.indexOf(ch);
					
					if (index != -1) {
						out.write(cryptSet.charAt((index + key) % cryptSet.length()));
						
					} else {
						out.write(ch);
					}
				}
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void encryptCharArr (int key) {
		try (
			FileReader in = new FileReader(franken);
			FileWriter out = new FileWriter(franken_encry);	
		) {
			FileWriter dup_out;
			alreadyExist(franken_encry);
			if (!(duplication.size() == 0)) {
				dup_out = new FileWriter(duplication.get(duplication.size() - 1));
				char[] buff = new char[2048];
				int len;
				int i = 0;
				while ((len = in.read(buff)) != -1) {
					for (char ch : buff) {
						int index = cryptSet.indexOf(ch);
						
						if (index != -1) {
							dup_out.write(cryptSet.charAt((index + key) % cryptSet.length()));
						} else {
							dup_out.write(ch);
						}
					}
				};
				
				dup_out.close();
			} else {
				char[] buff = new char[2048];
				int len;
				int i = 0;
				while ((len = in.read(buff)) != -1) {
					for (char ch : buff) {
						int index = cryptSet.indexOf(ch);
						
						if (index != -1) {
							out.write(cryptSet.charAt((index + key) % cryptSet.length()));
						} else {
							out.write(ch);
						}
					}
				};
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void BufferedEncrypt (int key) {
		try (
			FileReader fin = new FileReader(franken);
			BufferedReader br = new BufferedReader(fin);
			FileWriter out = new FileWriter(franken_encry);
		) {
			int len;
			while ((len = br.read()) != -1) {
				int index = cryptSet.indexOf(len);
				
				if (index != -1) {
					out.write(cryptSet.charAt((index + key) % cryptSet.length()));
				} else {
					out.write(len);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void alreadyExist(File f) {
		if (f.exists()) {
			String path = franken_encry.getPath();
			int index = duplication.size();
			duplication.add(new File(path.substring(0, path.indexOf('.')) + "(" + (index + 1)  + ").enc"));
		}
	}

	public static void main(String[] args) {
		int key = 5;
		long start, end;
		long time1, time2, time3;
		
		start = System.currentTimeMillis();
		encryptChar(key);
		end = System.currentTimeMillis();
		time1 = end - start;
				
		start = System.currentTimeMillis();
		encryptCharArr(key);
		end = System.currentTimeMillis();
		time2 = end - start;
				
		start = System.currentTimeMillis();
		BufferedEncrypt(3);
		end = System.currentTimeMillis();
		time3 = end - start;
		
		System.out.println("char : " + time1 + "ms");
		System.out.println("char[] : " + time2 + "ms");
		System.out.println("Buffered : " + time3 + "ms");
		

		
	}
}
