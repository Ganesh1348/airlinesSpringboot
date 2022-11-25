package com.SnapAirLines.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="sd_adn_cat_air")
public class Cat_detail_airLines 
{
	@TableGenerator(name = "initial_value", initialValue = 6000)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	@Column(name="phoneNumber", nullable=true)
	private Long phoneNo;
	@Column(nullable=true)   //by default nullable is true
	private String address;
	@Column(nullable=false)
	private int dcId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDcId() {
		return dcId;
	}
	public void setDcId(int dcId) {
		this.dcId = dcId;
	}
	
	
	
	
}
