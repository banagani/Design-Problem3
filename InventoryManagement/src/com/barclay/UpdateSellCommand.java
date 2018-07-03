package com.barclay;

public class UpdateSellCommand implements Command {

	private Inventory inventory;
	
	private UpdateSellItem updateSellItem;
	
	public UpdateSellCommand(Inventory inventory, UpdateSellItem updateSellItem){
		this.inventory=inventory;
		this.updateSellItem=updateSellItem;
	}
	@Override
	public void execute() {
		//open command is forwarding request to create method
		this.inventory.updateSell(updateSellItem);
	}

}
