package com.accolite.aman.SpringBatchCsvProcessor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class User {

	@Id
	public Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEPT")
	private String department;

	@Column(name = "SALARY")
	private Integer salary;

	@Column(name = "DATE")
	private Date date;

	public User(Long id, String name, String department, Integer salary, Date date) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.date = date;
	}

	public User(){
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", department='" + department + '\'' +
				", salary=" + salary +
				", date=" + date +
				'}';
	}
}
