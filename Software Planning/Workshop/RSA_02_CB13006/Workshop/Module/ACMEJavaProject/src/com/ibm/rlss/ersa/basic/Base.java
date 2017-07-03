package com.ibm.rlss.ersa.basic;


public class Base {
	
	private String id;
	private Helper listenerSupport = new Helper();

	public String getId() {
		return id;
	}
	
	public void workWith(MyEventListener listener) {
		listenerSupport.addListener(listener);
	}

}
