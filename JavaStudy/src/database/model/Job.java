package database.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Job {
	private Integer job_id;
	private String job_title;
	private Integer min_salary;
	private Integer max_salary;
	
	public Job(ResultSet rs) throws SQLException {
		job_id = rs.getInt(1);
		job_title = rs.getString(2);
		min_salary = rs.getInt(3);
		max_salary = rs.getInt(4);
	}

	public Integer getJob_id() {
		return job_id;
	}

	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public Integer getMin_salary() {
		return min_salary;
	}

	public void setMin_salary(Integer min_salary) {
		this.min_salary = min_salary;
	}

	public Integer getMax_salary() {
		return max_salary;
	}

	public void setMax_salary(Integer max_salary) {
		this.max_salary = max_salary;
	}

	@Override
	public String toString() {
		return "Job [job_id=" + job_id + ", job_title=" + job_title + ", min_salary=" + min_salary + ", max_salary="
				+ max_salary + "]";
	}
	
	
}
