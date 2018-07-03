package com.barclay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class DelegateRequest {
	
	public  void prepareRequest() {

		Inventory in = new InventoryImpl();
		String fileName = "C://30June//userInputCommands.txt";

		List<String> list = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(x -> list.add(x));

			for (String s : list) {
				if (s.startsWith(Constants.REPORT)) {
					return;
				}
				if (s.startsWith(Constants.CREATE)) {
					addItem(in, s);
				}
				if (s.startsWith(Constants.UPDATE_BUY)) {
					updateBuyItem(in, s);
				}
				if (s.contains(Constants.UPDATE_SELL)) {
					updateSellItem(in, s);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addItem(Inventory in, String s) {
		String[] str = s.split(" ");
		CreateItemCommand createItemCommand = new CreateItemCommand(in,
				new AddItem(str[1], Double.parseDouble(str[2]), Double.parseDouble(str[3])));
		OperationInvoker operation = new OperationInvoker(createItemCommand);
		operation.execute();
	}

	private  void updateBuyItem(Inventory in, String s) {
		String[] str = s.split(" ");
		UpdateBuyCommand updateBuyCommand = new UpdateBuyCommand(in,
				new UpdateBuyItem(str[1], Integer.parseInt(str[2])));
		OperationInvoker operation = new OperationInvoker(updateBuyCommand);
		operation.execute();
	}

	private  void updateSellItem(Inventory in, String s) {
		String[] str = s.split(" ");
		UpdateSellCommand updateSellCommand = new UpdateSellCommand(in,
				new UpdateSellItem(str[1], Integer.parseInt(str[2])));
		OperationInvoker operation = new OperationInvoker(updateSellCommand);
		operation.execute();
	}

	private  void deleteItem(Inventory in, String s) {
		String[] str = s.split(" ");
		DeleteCommand deleteCommand = new DeleteCommand(in, new DeleteItem(str[1]));
		OperationInvoker operation = new OperationInvoker(deleteCommand);
		operation.execute();
	}

	private  void updateSellPrice(Inventory in, String s) {
		String[] str = s.split(" ");
		UpdateSellPriceCommand updateSellPriceCommand = new UpdateSellPriceCommand(in,
				new UpdateSellPrice(str[1], Double.parseDouble(str[2])));
		OperationInvoker operation = new OperationInvoker(updateSellPriceCommand);
		operation.execute();
	}

	public  void generateReport() {
		InventoryImpl impl = new InventoryImpl();
		Map<String, ReportVO> reportMap = impl.inventoryMap;
		Set<String> itemNames = reportMap.keySet();
		Stream<String> itemNameStream= itemNames.stream().sorted();
		System.out.format("%32s%14s%16s%16s%10s%n", "", "", "Inventory Report", "", "");
		System.out.format("%32s%14s%16s%16s%10s%n", "Item Name", "Bought At", "Sold At", "Available Qty", "Value");
		System.out.format("%32s%14s%16s%16s%16s%n", "-------", "---------", "-------", "---------", "----------");
		
		itemNameStream.forEach(itemName -> {
			ReportVO vo = reportMap.get(itemName);
			System.out.format("%32s%10.2f%18.2f%16d%14.2f%n", itemName, vo.getBoughtAt(), vo.getSoldAt(), vo.getQty(),
					vo.getQty() * vo.getBoughtAt());
		});
		SummaryVO summary = getSummary(impl);
		System.out.format("%100s%n", "-------------------------------------------------------------------------");
		System.out.format("%100s%10.2f%n", "Total Value", summary.getTotalValue());
		System.out.format("%100s%10.2f%n", "Profit since previous report", summary.getProfit());
	}
	
	public  void prepareExtensionRequest() {

		Inventory in = new InventoryImpl();
		String fileName = "C://30June//userInputCommands.txt";

		List<String> list = new ArrayList<String>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(x -> list.add(x));

			for (String s : list) {
				if (s.startsWith(Constants.CREATE)) {
					addItem(in, s);
				} else if (s.startsWith(Constants.UPDATE_BUY)) {
					updateBuyItem(in, s);
				} else if (s.contains(Constants.UPDATE_SELL)) {
					updateSellItem(in, s);
				} else if (s.startsWith(Constants.DELETE)) {
					deleteItem(in, s);
				} else if (s.startsWith(Constants.UPDATE_SELL_PRICE)) {
					updateSellPrice(in, s);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void generateExtensionReport() {
		InventoryImpl impl = new InventoryImpl();
		Map<String, ReportVO> reportMap = impl.inventoryMap;
		Set<String> itemNames = reportMap.keySet();
		Stream<String> itemNameStream= itemNames.stream().sorted();
		System.out.format("%32s%14s%16s%16s%10s%n", "", "", "Inventory Report", "", "");
		System.out.format("%32s%14s%16s%16s%10s%n", "Item Name", "Bought At", "Sold At", "Available Qty", "Value");
		System.out.format("%32s%14s%16s%16s%16s%n", "-------", "---------", "-------", "---------", "----------");

		itemNameStream.forEach(itemName -> {
			ReportVO vo = reportMap.get(itemName);
			System.out.format("%32s%10.2f%18.2f%16d%14.2f%n", itemName, vo.getBoughtAt(), vo.getSoldAt(), vo.getQty(),
					vo.getQty() * vo.getBoughtAt());
		});
		SummaryVO summary = getSummary(impl);
		System.out.format("%100s%n", "-------------------------------------------------------------------------");
		System.out.format("%100s%10.2f%n", "Total Value", summary.getTotalValue());
	}

	public SummaryVO getSummary(InventoryImpl impl) {

		SummaryVO summary = new SummaryVO();
		double totalValue = 0.0;
		double profit = 0.0;
		Map<String, ReportVO> reportMap = impl.inventoryMap;
		Set<String> itemNames = reportMap.keySet();
		for (String item : itemNames) {
			ReportVO vo = reportMap.get(item);
			totalValue += vo.getQty() * vo.getBoughtAt();
			profit += vo.getProfit();
		}
		summary.setProfit(profit);
		summary.setTotalValue(totalValue);
		return summary;

	}

}
