package com.mindtree.kalingacafe.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cafe")
public class Cafe {
	@Id
	@Column(name="cafeId")
	private int cafeId;
	@Column(name="cafeName")
	private String cafeName;
	public Cafe() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Column(name="revenue")
	private int revenue;
	
//	@JsonIgnore

	@OneToOne(cascade=CascadeType.ALL)
	private Manager manager;


	public Cafe(int cafeId, String cafeName, int revenue, Manager manager) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.revenue = revenue;
		this.manager = manager;
	}
	public int getCafeId() {
		return cafeId;
	}
	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}
	public String getCafeName() {
		return cafeName;
	}
	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}
	public int getRevenue() {
		return revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	@JsonIgnore
	public Manager getManager() {
		return manager;
	}
	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
