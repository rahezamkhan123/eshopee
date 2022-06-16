package com.alzohareshopee.webservice.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import com.sun.istack.NotNull;

@Entity
@Table(name = "eshopee_customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "customer_generator")
	@SequenceGenerator(name = "customer_generator", initialValue = 1, allocationSize = 1, sequenceName = "customer_seq")
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	@NotNull
	@Size(min = 10, message = "Name should have atleast 10 characters")
	private String name;

	@Column(name = "email", unique = true, columnDefinition = "varchar(195)")
	@NotNull
	@Size(min = 15, message = "Name should have atleast 10 characters")
	private String email;

	@Column(name = "address")
	@NotNull
	@Size(min = 20, message = "address should have atleast 20 characters")
	private String address;

	@Column(name = "gender")
	@NotNull
	@Size(min = 4, message = "gender should have atleast 6 characters")
	private String gender;

	@NotBlank
	@Column(name = "city")
	private String city;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt = new Date();

	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;

	@OneToOne(cascade = CascadeType.ALL)
	private House house;

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
