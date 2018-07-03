package com.barclay;

public class ReportVO {
	
private String itemName;
	
	private double boughtAt;
	
	private double soldAt;
	
	private int qty;
	
	private double profit;
	
	private double newPrice;

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

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
