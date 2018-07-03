package com.barclay;

public class CreateItemCommand implements Command {

	private Inventory inventory;
	
	private AddItem  addItem;
	
	public CreateItemCommand(Inventory inventory, AddItem addItem){
		this.inventory=inventory;
		this.addItem=addItem;
	}
	@Override
	public void execute() {
		//create command is forwarding request to create method
		this.inventory.create(addItem);
	}

}
