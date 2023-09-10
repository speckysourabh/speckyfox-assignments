package com.sfx.component.controller;

import com.sfx.component.Controller;

public class StandardController implements Controller {

	@Override
	public String componentType() {
		return "Standard Controller";
	}
	
	@Override
	public int price() {
		return 10000;
	}

}
