package myobj.submit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Franken_Encrypt {
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
	String cryptSet = "ABCDEFGHIJKLMNOPQRSUVWXYZ0123456789!@#$%^&*()-_=+"
			+ "abcdefghijklmnopqrsuvwxyz {}[]|\\;:'\"/?<>,.";
	
	File franken = new File("franken/frankenstein.txt");
	File encrypt = new File("franken/frankenstein_encrypted.enc");
	File decrypt = new File("franken/frankenstein_decrypt.enc");
	File exceed;
	static int dupleNum = 1;
	
	
	String time;
	long start, end;
	
	public void changeAllFile(File origin) {
		franken = changeOrigin(origin);
		String origin_name = franken.getName();
		origin_name = origin_name.substring(0, origin_name.indexOf('.'));
		
		encrypt = changeEncrypt(new File(franken.getParent(), 
				origin_name + "_encrypted.enc"));
		decrypt = changeDecrypt(new File(franken.getParent(),
				origin_name + "_decrypt.enc"));
		
	}
	
	public File changeOrigin(File franken) {
		this.franken = franken;
		return this.franken;
	}
	
	public File changeEncrypt(File encrypt) {
		this.encrypt = encrypt;		
		return this.encrypt;
	}
	
	public File changeDecrypt(File decrypt) {
		this.decrypt = decrypt;
		return this.decrypt;
	}
	
	public void createEncryptFile(int key) {
		if (encrypt.exists()) {
			String dupleName = encrypt.getName();
			dupleName = dupleName.substring(0, dupleName.indexOf("."));
			dupleName = dupleName + "(" + dupleNum++ + ").enc";

			exceed = new File(encrypt.getParent(), dupleName);
			if (exceed.exists()) {
				createEncryptFile(key);
			} else {
				bufferedEncrypt(franken, exceed, key);
			}
			
		} else {
			bufferedEncrypt(key);
		}
		
		
	}
	
	private String msTime() {
		StringBuilder sb = new StringBuilder();
		long time = end - start;
		
		sb.append(time);
		sb.append("ms");
		
		return this.time = new String(sb);
	}
	
	private void charEncrypt(int key) {
		try (
			FileReader in = new FileReader(franken);
			FileWriter out = new FileWriter(encrypt);	
		) {
			int len;
			while((len = in.read()) != -1) {
				int index = cryptSet.indexOf(len);
				if (index == -1) {
					out.write(len);
				} else {			
					key %= cryptSet.length();
					char ch = cryptSet.charAt((index + key) % cryptSet.length());
					out.write(ch);
				}
								
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void charArrEncrypt(int key) {
		try (
				FileReader in = new FileReader(franken);
				FileWriter out = new FileWriter(encrypt);	
			) {
				char[] buff = new char[2048];
				int len;
				//int i = 0;
				while ((len = in.read(buff)) != -1) {
					for (char ch : buff) {
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
	
	private void bufferedEncrypt(File origin, File encrypt, int key) {
		
		
		try (
			FileReader fin = new FileReader(origin);
			FileWriter fout = new FileWriter(encrypt);	
			BufferedReader br = new BufferedReader(fin);
			BufferedWriter bw = new BufferedWriter(fout);
		) {

			int len;
			while((len = br.read()) != -1) {
				int index = cryptSet.indexOf(len);

				if (index != -1) {
					bw.write(cryptSet.charAt((index + key) % cryptSet.length()));
				} else {
					bw.write(len);
				}
								
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	private void bufferedEncrypt(int key) {
		
		
		try (
			FileReader fin = new FileReader(franken);
			FileWriter fout = new FileWriter(encrypt);	
			BufferedReader br = new BufferedReader(fin);
			BufferedWriter bw = new BufferedWriter(fout);
		) {

			int len;
			while((len = br.read()) != -1) {
				int index = cryptSet.indexOf(len);

				if (index != -1) {
					bw.write(cryptSet.charAt((index + key) % cryptSet.length()));
				} else {
					bw.write(len);
				}
								
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	public void FileDecrypt(int key) {
		try (
			FileReader fin = new FileReader(encrypt);
			BufferedReader br = new BufferedReader(fin);
			FileWriter fout = new FileWriter(decrypt);	
			BufferedWriter bw = new BufferedWriter(fout);
		) {
			int len;
			int len2 = cryptSet.length();
			char ch;
			
			while((len = br.read()) != -1) {
				int index = cryptSet.indexOf(len);
				
				if (index == -1) {
					bw.write(len);
				} else {			
					key %= len2;
					if (index - key < 0) {
						ch = cryptSet.charAt(index - key + len2);
					} else {
						ch = cryptSet.charAt(index - key);
					}
					bw.write(ch);
					
				}
								
			}
								

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void FileDecrypt(File encrypt, int key) {
		try (
			FileReader fin = new FileReader(encrypt);
			BufferedReader br = new BufferedReader(fin);
			FileWriter fout = new FileWriter(decrypt);	
			BufferedWriter bw = new BufferedWriter(fout);
		) {
			int len;
			int len2 = cryptSet.length();
			char ch;
			
			while((len = br.read()) != -1) {
				int index = cryptSet.indexOf(len);
				
				if (index == -1) {
					bw.write(len);
				} else {			
					key %= len2;
					if (index - key < 0) {
						ch = cryptSet.charAt(index - key + len2);
					} else {
						ch = cryptSet.charAt(index - key);
					}
					bw.write(ch);
					
				}
								
			}
								

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getTimeEachMethod(int key) {
		String time;
		start = System.currentTimeMillis();
		charEncrypt(key);
		end = System.currentTimeMillis();
		time = msTime();
		System.out.println("charEncrypt: " + time);
		
		start = System.currentTimeMillis();
		charArrEncrypt(key);
		end = System.currentTimeMillis();
		time = msTime();
		System.out.println("charArrEncrypt: " + time);
		
		start = System.currentTimeMillis();
		bufferedEncrypt(key);
		end = System.currentTimeMillis();
		time = msTime();
		System.out.println("bufferedEncrypt: " + time);
	}
	
	public static void main(String[] args) {
		Franken_Encrypt f = new Franken_Encrypt();
		int key = 3;
		//f.changeAllFile(new File("myfiles/emails.txt"));
		// 각  방법 시간재기
		f.getTimeEachMethod(key);
		// 암호해독
		f.FileDecrypt(key);
		
		f.createEncryptFile(key);
		
		
		
		
		
	}
	
}
