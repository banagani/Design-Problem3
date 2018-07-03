package com.barclay;

import java.util.HashMap;
import java.util.Map;

public class InventoryImpl implements Inventory {

	public static Map<String, ReportVO> inventoryMap = new HashMap<String, ReportVO>();

	@Override
	public void create(AddItem addItem) {
		inventoryMap.put(addItem.getItemName(), addItem);
	}

	@Override
	public void updateSell(UpdateSellItem sellItem) {
		ReportVO vo = inventoryMap.get(sellItem.getItemName());
		int sellQty = vo.getQty() - sellItem.getQty();
		vo.setQty(sellQty);
		vo.setProfit((sellItem.getQty() * (vo.getSoldAt() - vo.getBoughtAt())) + vo.getProfit());
		inventoryMap.put(sellItem.getItemName(), vo);

	}

	@Override
	public void updateBuy(UpdateBuyItem buyItem) {
		ReportVO vo = inventoryMap.get(buyItem.getItemName());
		vo.setQty(buyItem.getQty());
		inventoryMap.put(buyItem.getItemName(), vo);
	}

	@Override
	public void delete(DeleteItem deleteItem) {
		inventoryMap.remove(deleteItem.getItemName());

	}

	@Override
	public void UpdateSellPrice(com.barclay.UpdateSellPrice updateSellPrice) {
		ReportVO vo = inventoryMap.get(updateSellPrice.getItemName());
		vo.setNewPrice(updateSellPrice.getNewPrice());
		inventoryMap.put(updateSellPrice.getItemName(), vo);
	}

}
