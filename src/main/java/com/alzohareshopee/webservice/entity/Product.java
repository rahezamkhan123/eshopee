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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@NamedQueries(value = {
//		@NamedQuery(name = "getProductByName", query = "select * from eshopee_product as eprod where eprod.name = name") })

@Entity
@Table(name = "eshopee_product")
public class Product {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "productid_generator")
	@SequenceGenerator(name = "productid_generator", initialValue = 1, allocationSize = 1, sequenceName = "productid_seq")
	private long id;

	@Column(name = "name")
	@NotEmpty
	private String name;

	@Column(name = "description")
	@NotBlank(message = "Description is Empty")
	private String description;

	@Column(name = "price")
	private double price;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "seller")
	private String seller;

	@Column(name = "weight")
	private int weight;

	@Column(name = "type")
	private int type;

	@Column(name = "created_at")
	private Date createdAt = new Date();

	@Column(name = "modifiedat")
	private Date modifiedAt = new Date();

	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetails details;

	public ProductDetails getDetails() {
		return details;
	}

	public void setDetails(ProductDetails details) {
		this.details = details;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
