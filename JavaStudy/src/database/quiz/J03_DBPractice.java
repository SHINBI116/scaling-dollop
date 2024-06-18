package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import database.DBConnector;

public class J03_DBPractice {
	/*
		(1) DB에 새 계정을 추가한다
		
		(2) 관리자 계정으로 새 계정에 권한을 부여한다
		
		(3) 해당 계정에 새 테이블을 추가한다
			(기본키로 시퀀스를 사용해야하고, 제약조건을 종류별로 모두 사용해야 한다)
			
		(4) 프로그램에서 스캐너로 데이터를 입력하면 DB에 행이 추가되어야 한다
		
		(5) 콘솔에서 여태까지 추가된 모든 행을 조회 할 수 있어야 한다
	 */
	private static DBConnector connector = new DBConnector("petshop", "1234");
	
	public static void insertAnimalKind(String kor, String eng) {
		String sql = "INSERT INTO animal_kind(kind_id, kor_name, eng_name)"
				+ " VALUES(animal_kind_seg.nextval, ?, ?)";
		try (
			Connection conn = connector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, kor);
			pstmt.setString(2, eng);
			
			int row = pstmt.executeUpdate();
			System.out.printf("%d행 업데이트되었습니다.\n", row);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 동물 종류 추가하기");
			System.out.println("2. 동물 맡기기");
			System.out.println("3. 동물 다시 데려가기");			
			System.out.print(">>");
			
			int select = sc.nextInt();
			sc.nextLine(); // \n제거
			switch(select) {
				case 1:
					System.out.print("동물의 한글이름은? ");
					String korName = sc.nextLine();
					System.out.print("동물의 영어이름은? ");
					String engName = sc.nextLine();
					
					insertAnimalKind(korName, engName);
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
			}
		}
		
		//insertAnimalKind("골든 리트리버", "Golden Retriever");
	}
	
	
		
}
