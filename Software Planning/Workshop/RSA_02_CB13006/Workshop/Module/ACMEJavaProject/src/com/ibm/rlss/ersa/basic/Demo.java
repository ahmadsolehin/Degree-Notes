package com.ibm.rlss.ersa.basic;

public class Demo extends Base implements Echo, Dummy {
	
	private int priority;


	public String echo(String message) {
		return "Hello " + message;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
