package com.SnapAirLines.demo;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "SM_ADM_AIRLINES")
public class airLines {
	@TableGenerator(name = "initial_value", initialValue = 4700)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "initial_value")
	public int id;
	@Column(name = "NAMES")
	public String airLinesNames;
	@Column(name = "address")
	public String airLinesAddress;
	@Column(name = "Types")
	public String airLinesTypes;
	// fetch used to the data. fetch having 2 type like lazy and eager. eager type
	// return query with "join statement"
	// .Lazy type return the 2 different select query ,by dafault java consider as
	// lazy
	// Cascade saying child to save also.
	@OneToMany(targetEntity = detailAirLines.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "air_id", referencedColumnName = "id")
	private List<detailAirLines> detailAirLines;

	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
	private String creationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirLinesNames() {
		return airLinesNames;
	}

	public void setAirLinesNames(String airLinesNames) {
		this.airLinesNames = airLinesNames;
	}

	public String getAirLinesAddress() {
		return airLinesAddress;
	}

	public void setAirLinesAddress(String airLinesAddress) {
		this.airLinesAddress = airLinesAddress;
	}

	public String getAirLinesTypes() {
		return airLinesTypes;
	}

	public void setAirLinesTypes(String airLinesTypes) {
		this.airLinesTypes = airLinesTypes;
	}

	public List<detailAirLines> getDetailAirLines() {
		return detailAirLines;
	}

	public void setDetailAirLines(List<detailAirLines> detailAirLines) {
		this.detailAirLines = detailAirLines;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "airLines [id=" + id + ", airLinesNames=" + airLinesNames + ", airLinesAddress=" + airLinesAddress
				+ ", airLinesTypes=" + airLinesTypes + ", creationDate=" + creationDate + "]";
	}

}
