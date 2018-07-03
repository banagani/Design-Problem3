package com.barclay;

public class InventoryManagementClient {

	public static void main(String[] args) {

		DelegateRequest delegateRequest = new DelegateRequest();
		delegateRequest.prepareRequest();

		delegateRequest.generateReport();

		delegateRequest.prepareExtensionRequest();

		delegateRequest.generateExtensionReport();
	}

}