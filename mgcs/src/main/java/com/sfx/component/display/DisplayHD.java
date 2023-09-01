package com.sfx.component.display;

public class DisplayHD implements Display {
	
	@Override
	public String displayType() {
		return "HD display";
	}

	@Override
	public int price() {
		return 2000;
	}

}
