package com.SnapAirLines.demo;

public class CatAirLinesModel {

	private Integer airId;
	private String owner;
	private String names;
	private String types;

	public Integer getAirId() {
		return airId;
	}

	public void setAirId(Integer airId) {
		this.airId = airId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public CatAirLinesModel(Integer airId, String owner, String names, String types) {
		super();
		this.airId = airId;
		this.owner = owner;
		this.names = names;
		this.types = types;
	}

	public CatAirLinesModel() {
		super();
	}

	@Override
	public String toString() {
		return "CatAirLinesModel [airId=" + airId + ", owner=" + owner + ", names=" + names + ", types=" + types + "]";
	}

}
