package com.sfx.component.display;

import com.sfx.component.Display;

public class Display4k implements Display {

	@Override
	public String componentType() {
		return "4k display";
	}

	@Override
	public int price() {
		return 40000;
	}

}
