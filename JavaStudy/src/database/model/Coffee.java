package database.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Coffee {
	private Integer coffee_id;
	private String coffee_name;
	private Integer coffee_price;
	
	public Coffee(Integer coffee_id, String coffee_name, Integer coffee_price) {
		this.coffee_id = coffee_id;
		this.coffee_name = coffee_name;
		this.coffee_price = coffee_price;
	}
	
	public Coffee (ResultSet rs) throws SQLException {
		coffee_id = rs.getInt("coffee_id");
		coffee_name = rs.getString("coffee_name");
		coffee_price = rs.getInt("coffee_price");
	}
	
	public Integer getCoffee_id() {
		return coffee_id;
	}
	public void setCoffee_id(Integer coffee_id) {
		this.coffee_id = coffee_id;
	}
	public String getCoffee_name() {
		return coffee_name;
	}
	public void setCoffee_name(String coffee_name) {
		this.coffee_name = coffee_name;
	}
	public Integer getCoffee_price() {
		return coffee_price;
	}
	public void setCoffee_price(Integer coffee_price) {
		this.coffee_price = coffee_price;
	}
	
	
	@Override
	public String toString() {
		return "Coffee [coffee_id=" + coffee_id + ", coffee_name=" + coffee_name + ", coffee_price=" + coffee_price
				+ "]";
	}
	
	
}
