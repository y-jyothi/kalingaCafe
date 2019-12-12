package com.mindtree.kalingacafe.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="manager")
public class Manager {
	
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", managerName=" + managerName + ", salary=" + salary + ", cafe="
				+ cafe + "]";
	}

	@Id
	@Column(name="managerId")
	private int managerId;
	@Column(name="managerName")
	private String managerName;
	@Column(name="salary")
	private int salary;
	
	
//	@JsonIgnore

	@OneToMany(cascade=CascadeType.ALL,mappedBy="manager",fetch=FetchType.EAGER)
	private List<Cafe> cafe;
	@JoinColumn(name="managerId")

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Cafe> getCafe() {
		return cafe;
	}

	public void setCafe(List<Cafe> cafe) {
		this.cafe = cafe;
	}

	public Manager(int managerId, String managerName, int salary, List<Cafe> cafe) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.salary = salary;
		this.cafe = cafe;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
