package com.barclay;

public class UpdateSellPriceCommand implements Command {

	private Inventory inventory;
	
	private UpdateSellPrice updateSellPrice;
	
	public UpdateSellPriceCommand(Inventory inventory, UpdateSellPrice updateSellPrice){
		this.inventory=inventory;
		this.updateSellPrice=updateSellPrice;
	}
	@Override
	public void execute() {
		//open command is forwarding request to create method
		this.inventory.UpdateSellPrice(updateSellPrice);
	}
}