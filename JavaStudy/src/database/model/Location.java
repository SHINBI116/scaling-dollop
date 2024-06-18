package database.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Location {
	private Integer location_id;
	private String street_address;
	private String postal_code;
	private String city;
	
	public Location(ResultSet rs) throws SQLException {
		location_id = rs.getInt(1);
		street_address = rs.getString(2);
		postal_code = rs.getString(3);
		city = rs.getString(4);
	}
	
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Location [location_id=" + location_id + ", street_address=" + street_address + ", postal_code="
				+ postal_code + ", city=" + city + "]";
	}
	
	
	
}
