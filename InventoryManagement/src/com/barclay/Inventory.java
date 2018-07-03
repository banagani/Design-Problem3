package com.barclay;

public interface Inventory {

	void updateSell(UpdateSellItem sellItem);

	void updateBuy(UpdateBuyItem item);

	void delete(DeleteItem deleteItem);

	void create(AddItem addItem);

	void UpdateSellPrice(UpdateSellPrice updateSellPrice);

}
