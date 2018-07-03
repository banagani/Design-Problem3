package com.barclay;

public class UpdateBuyCommand implements Command {

	private Inventory inventory;
	private UpdateBuyItem item;
	
	public UpdateBuyCommand(Inventory inventory, UpdateBuyItem item){
		this.inventory=inventory;
		this.item=item;
	}
	@Override
	public void execute() {
		//open command is forwarding request to create method
		this.inventory.updateBuy(item);
	}

}
