package com.barclay;

public class DeleteCommand implements Command {

	private Inventory inventory;
	
	private DeleteItem deleteItem;
	
	public DeleteCommand(Inventory inventory, DeleteItem deleteItem){
		this.inventory=inventory;
		this.deleteItem=deleteItem;
	}
	@Override
	public void execute() {
		//Delete command is forwarding request to Delete method
		this.inventory.delete(deleteItem);
	}

}


