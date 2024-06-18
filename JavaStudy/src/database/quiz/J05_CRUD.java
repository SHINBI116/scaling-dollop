package database.quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DBConnector;
import database.model.Coffee;

public class J05_CRUD {
	
	static DBConnector connector = new DBConnector("HR", "1234");
	
	// (1) 모든 커피 목록을 리스트 형태로 반환하는 메서드
	public static List<Coffee> getCoffeeList() {
		List<Coffee> list = new ArrayList<>();
				
		try (
			Connection conn = connector.getConnection();
			
		) {	
			String sql = "SELECT * FROM coffee ORDER BY coffee_id";
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			) {
				while(rs.next()) {
					Coffee coffee = new Coffee(rs);
					list.add(coffee);
				}
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	// (2) 커피 이름으로 검색한 결과를 리스트 형태로 반환하는 메서드 (LIKE)
	public static List<Coffee> searchCoffeeNameList(String coffee_name) {
		List<Coffee> list = new ArrayList<>();
		
		String sql = "SELECT * FROM coffee WHERE coffee_name LIKE ?";
		
		try (
				Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, coffee_name);
					
				try (
					ResultSet rs = pstmt.executeQuery();
				) {
					while(rs.next()) {
						Coffee coffee = new Coffee(rs);
						list.add(coffee);
					}
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
	}
	
	
	// (3) 새로운 커피를 추가하는 메서드 (추가할 때 시퀀스 사용)
	public static void addNewCoffee(String coffee_name, Integer coffee_price) {
		String sql = "INSERT INTO coffee VALUES(coffee_seq.nextval, ?, ?)";
		try (
				Connection conn = connector.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setString(1, coffee_name);
				pstmt.setInt(2, coffee_price);	
				

				int row = pstmt.executeUpdate();
				
				System.out.printf("%d행이 추가되었습니다.\n", row);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	// (4) 이미 존재하는 커피의 정보를 수정할 수 있는 메서드 (기본키는 수정 불가능)
	public static boolean updateCoffee(Coffee coffee) {
		// 1. 전달받은 coffee의 id값으로 update
		String sql = "UPDATE coffee SET"
				+ " coffee_price = ?, coffee_name = ?"
				+ " WHERE coffee_id = ?";
		
		// update를 실행했는데 변한 행이 0이라면 수정 실패, 1이면 성공
		try (
			Connection conn = connector.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setInt(1, coffee.getCoffee_price());
			pstmt.setString(2, coffee.getCoffee_name());
			pstmt.setInt(3, coffee.getCoffee_id());
			
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	// (5) 커피ID를 매개변수로 전달받으면 해당 커피를 삭제하고 삭제 여부를 반환해주는 메서드
	public static boolean removeCoffee(Integer coffee_id) {
		String sql = "DELETE FROM coffee WHERE coffee_id = ?";
		
		try (
			Connection conn = connector.getConnection();
			
		) {
			conn.setAutoCommit(false);
			
			try (
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) {
				pstmt.setInt(1, coffee_id);
				
				int row = pstmt.executeUpdate();
				
				
				if (row == 0) {
					return false;
				} 
				System.out.printf("%d행이 삭제되었습니다.\n", row);
				
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();			
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		
		for (Coffee coffee : getCoffeeList()) {
			System.out.println(coffee);
		}
		System.out.println("-------------------------------");
		for (Coffee c :searchCoffeeNameList("%c%")) {
			System.out.println(c);
		}
		
		//addNewCoffee("ice tea", 1500);
		
		//updateCoffee(1800, 1);
		//removeCoffee(6);
		
		boolean result = updateCoffee(new Coffee(1, "Americano", 2200));
		
		System.out.println(result);
	}
	
	
}
