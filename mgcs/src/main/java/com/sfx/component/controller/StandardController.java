package com.sfx.component.controller;

public class StandardController implements Controller {

	@Override
	public String controllerType() {
		return "Standard Controller";
	}
	
	@Override
	public int price() {
		return 10000;
	}

}
