package com.alzohareshopee.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eshopee_salary")
public class Salary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "Designation")
	private String Designation;

	@Column(name = "month")
	private String Month;

	@Column(name = "ctc")
	private long CTC;

	@Column(name = "basic_salary")
	private long BasicSalary;

	@Column(name = "bonus")
	private long Bonus;

	@Column(name = "tds")
	private long TDS;

	@Column(name = "total_salary")
	private long TotalSalary;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getMonth() {
		return Month;
	}

	public void setMonth(String month) {
		Month = month;
	}

	public long getCTC() {
		return CTC;
	}

	public void setCTC(long cTC) {
		CTC = cTC;
	}

	public long getBasicSalary() {
		return BasicSalary;
	}

	public void setBasicSalary(long basicSalary) {
		BasicSalary = basicSalary;
	}

	public long getBonus() {
		return Bonus;
	}

	public void setBonus(long bonus) {
		Bonus = bonus;
	}

	public long getTDS() {
		return TDS;
	}

	public void setTDS(long tDS) {
		TDS = tDS;
	}

	public long getTotalSalary() {
		return TotalSalary;
	}

	public void setTotalSalary(long totalSalary) {
		TotalSalary = totalSalary;
	}

}
