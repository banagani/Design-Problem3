package com.barclay;

public class DeleteItem extends ReportVO {

	private String itemName;

	public DeleteItem(String itemName) {
		super();
		this.itemName = itemName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
