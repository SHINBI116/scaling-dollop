package quiz;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class E07_Copy {
	// 폴더의 경로를 전달하면 같은 경로에 폴더이름2를 만들고 
	// 안의 모든 내용을 복사해주는 메서드를 만들어보세요
	
	// ex > dog 폴더 경로를 전달하면 안에 있는 모든 강아지 사진이 복사된 dog2폴더가 생겨야 함
	// ex > myimage 폴더의 경로를 전달하면 내부의 모든 내용이 그대로인 myimage2가 생겨야 함
	
	public static void copy(String path) {
		String dest = path + "2";
		System.out.println(dest);
		File copyFolder = new File(dest);
		if (!copyFolder.exists()) {
			copyFolder.mkdirs();
		}
		// 원래 경로에 들어있는 파일들의 목록을 꺼낸다
		String[] files = new File(path).list();
		
		System.out.println(Arrays.toString(files));
		HashMap<String, String[]> filesMap = new HashMap<>();
		
		for (String pfile : files) {
			String[] source = new File(path + "/" + pfile).list();
			filesMap.put(pfile, source);
		}
	
		

		
//		ArrayList<Character> chList = new ArrayList<>();
//		for (String file : files) {
//			FileReader in = null;
//			try {
//				in = new FileReader(path + "/" + file);
//				int ch ;				
//				while ((ch = in.read()) != -1) {
//					chList.add((char)ch);
//				}
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (in != null) {
//						in.close();
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			 //System.out.println(chList);
//			
//			 FileWriter out = null;
//				
//					try {
//						out = new FileWriter(dest + "/" + file );
//						for (int i = 0; i < chList.size(); ++i) {
//							out.append(chList.get(i));
//						}
//					} catch (IOException e) {
//						
//						e.printStackTrace();
//					} finally {
//						try {
//							if (out != null) {
//								out.close();
//							}
//						} catch (IOException e) {
//							e.printStackTrace();
//						}
//					}
//					chList.removeAll(chList);
//					
//				
//		} 
//			
////			 읽은 후 읽은 내용을 그대로 원하는 위치에 다시 쓰면 복사
//
	}
	
	

	
	public static void main(String[] args) {
		copy("./myimages");
		
//		File test = new File("./myimages/animals/dogs/다운로드 (1).jpg");
//		System.out.println(test.exists());

	}
}
