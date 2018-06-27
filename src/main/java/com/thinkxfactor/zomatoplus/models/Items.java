package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name= "tbl_items")
public class Items implements Serializable{
	@Id
	@GeneratedValue
	
	@Column(name = "item_id")
	private long id;
	
	@Column(name = "restaurant_id")
	private long restaurantid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "description")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(Long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public Items() {
		super();
	}

	public Items(Long id, Long restaurantid, String name, Double price, String description) {
		super();
		this.id = id;
		this.restaurantid = restaurantid;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	
}
