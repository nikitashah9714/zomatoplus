package com.thinkxfactor.zomatoplus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity  //All these annotations here come from java.persistence
@Table(name = "tbl_user")     //User table name is to be given
public class User implements Serializable {
	@Id
	@GeneratedValue   //To tell that the primary key is auto generated
	
	@Column(name = "user_id")
	private long id;  //Primary key
	
	@Column(name = "name",unique=true)
	private String name;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "landmark")
	private String landmark;
	
	@Column(name = "pincode")
	private String pincode;
	
	public User(long id, String name, String type, String mobile, String address, String password, String landmark,
			String pincode) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.mobile = mobile;
		this.address = address;
		this.password = password;
		this.landmark = landmark;
		this.pincode = pincode;
	}

	public User() {
		super();
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	
}
