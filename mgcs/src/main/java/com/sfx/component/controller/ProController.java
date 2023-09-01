package com.sfx.component.controller;

public class ProController implements Controller {

	@Override
	public String controllerType() {
		return "Pro Controller with advanced haptic feedback";
	}

	@Override
	public int price() {
		return 25000;
	}
	
}
