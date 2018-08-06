package com.accolite.aman.SpringBatchCsvProcessor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

	public User(Long id, String name, String department, Integer salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
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

	public void setDepartment(String deptCode) {
		this.department = deptCode;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", department='" + department + '\'' +
				", salary=" + salary +
				'}';
	}
}
