package com.barclay;

public class OperationInvoker {
	
	public Command command;
	
	public OperationInvoker(Command c){
		this.command=c;
	}
	
	public void execute(){
		this.command.execute();
	}

}
