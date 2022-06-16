package com.alzohareshopee.webservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "eshopee_order")
public class Order {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orderid_generator")
	@SequenceGenerator(name = "orderid_generator", initialValue = 1, allocationSize = 1, sequenceName = "orderid_seq")
	private long id;
	@Column(name = "name")
	@NotEmpty
	private String name;
	@Column(name = "price")
	@NumberFormat(style = Style.CURRENCY)
	private double price;
	@Column(name = "description")
	private String description;
	@Column(name = "orderType")
	private String orderType;
	@Column(name = "quantity")
	private long quantity;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "expire_at")
	private Date expireAt;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "created_at")
	private Date createdAt;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
