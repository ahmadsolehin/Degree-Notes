package com.ibm.rlss.ersa.basic;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class Helper extends Base {
	private List<MyEventListener> listeners = new ArrayList<MyEventListener>();

	public void addListener(MyEventListener listener) {
		listeners.add(listener);
	}

	public boolean removeListener(MyEventListener listener) {
		return listeners.remove(listener);
	}
	
	public void notify(EventObject event) {
		for (MyEventListener listener : listeners) {
			listener.notify(event);
		}
	}

}
