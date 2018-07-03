package com.barclay;

public class AddItem extends ReportVO {

	private String itemName;

	private double boughtAt;

	public AddItem(String itemName, double boughtAt, double soldAt) {
		super();
		this.itemName = itemName;
		this.boughtAt = boughtAt;
		this.soldAt = soldAt;
	}

	private double soldAt;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getBoughtAt() {
		return boughtAt;
	}

	public void setBoughtAt(double boughtAt) {
		this.boughtAt = boughtAt;
	}

	public double getSoldAt() {
		return soldAt;
	}

	public void setSoldAt(double soldAt) {
		this.soldAt = soldAt;
	}
}
