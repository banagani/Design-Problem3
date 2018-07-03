package com.barclay;

public class UpdateBuyItem extends ReportVO{
	
	private String itemName;
	
	private int qty;

	public UpdateBuyItem(String itemName, int qty) {
		super();
		this.itemName = itemName;
		this.qty = qty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
