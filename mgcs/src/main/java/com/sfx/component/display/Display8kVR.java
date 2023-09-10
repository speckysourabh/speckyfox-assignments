package com.sfx.component.display;

import com.sfx.component.Display;

public class Display8kVR implements Display {
	
	@Override
	public String componentType() {
		return "8kVR display";
	}

	@Override
	public int price() {
		return 80000;
	}

}
