package com.ibm.rlss.ersa.basic;

import java.util.EventListener;
import java.util.EventObject;

public interface MyEventListener extends EventListener {
	
	public void notify(EventObject eventObject);

}
