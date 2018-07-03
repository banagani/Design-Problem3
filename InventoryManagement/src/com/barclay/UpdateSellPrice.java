package com.barclay;

public class UpdateSellPrice extends ReportVO{
	
	private String itemName;
	
	private double newPrice;

	public UpdateSellPrice(String itemName, double newPrice) {
		super();
		this.itemName = itemName;
		this.newPrice= newPrice;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}