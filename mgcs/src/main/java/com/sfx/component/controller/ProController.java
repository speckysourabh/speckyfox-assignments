package com.sfx.component.controller;

import com.sfx.component.Controller;

public class ProController implements Controller {

	@Override
	public String componentType() {
		return "Pro Controller with advanced haptic feedback";
	}

	@Override
	public int price() {
		return 25000;
	}
	
}
