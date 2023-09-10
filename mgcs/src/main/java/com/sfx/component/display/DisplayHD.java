package com.sfx.component.display;

import com.sfx.component.Display;

public class DisplayHD implements Display {
	
	@Override
	public String componentType() {
		return "HD display";
	}

	@Override
	public int price() {
		return 2000;
	}

}
