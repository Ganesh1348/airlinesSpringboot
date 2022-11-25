package com.SnapAirLines.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SD_ADM_AIRLINES")
public class detailAirLines {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int detailId;
	@Column(name = "FROMCITY")
	private String fromCity;
	@Column(name = "TOCITY")
	private String toCity;
	@Column(name = "AVAILABLESEATS")
	private String availeableSeats;
	@Column(name = "TOTALSEATS")
	private String totalSeats;
	@Column(name = "TYPE")
	private String airLinesType;
	private int ticketRate;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getAvaileableSeats() {
		return availeableSeats;
	}

	public void setAvaileableSeats(String availeableSeats) {
		this.availeableSeats = availeableSeats;
	}

	public String getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(String totalSeats) {
		this.totalSeats = totalSeats;
	}

	public String getAirLinesType() {
		return airLinesType;
	}

	public void setAirLinesType(String airLinesType) {
		this.airLinesType = airLinesType;
	}

	public int getTicketRate() {
		return ticketRate;
	}

	public void setTicketRate(int ticketRate) {
		this.ticketRate = ticketRate;
	}

}
