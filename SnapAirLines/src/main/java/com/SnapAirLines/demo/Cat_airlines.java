package com.SnapAirLines.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "sm_adn_cat_air")
public class Cat_airlines {
	@TableGenerator(name = "initial_value", initialValue = 5000)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Column(name = "owner", nullable = false, insertable = true, updatable = true)
	private String owner;
	@Column(name = "mainDcId", nullable = false)
	private int m_dcId;
	@Column(name = "type", nullable = false) // false don't accept null
	private String type;
	@OneToMany(targetEntity = Cat_detail_airLines.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cat_id", referencedColumnName = "id")
	private List<Cat_detail_airLines> cat_detail_airLines;
	@Column(name = "airLines_id")
	private Integer airLinesId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getM_dcId() {
		return m_dcId;
	}

	public void setM_dcId(int m_dcId) {
		this.m_dcId = m_dcId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Cat_detail_airLines> getCat_detail_airLines() {
		return cat_detail_airLines;
	}

	public void setCat_detail_airLines(List<Cat_detail_airLines> cat_detail_airLines) {
		this.cat_detail_airLines = cat_detail_airLines;
	}

	public Integer getAirLinesId() {
		return airLinesId;
	}

	public void setAirLinesId(Integer airLinesId) {
		this.airLinesId = airLinesId;
	}

}
