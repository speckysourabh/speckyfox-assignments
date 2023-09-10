package com.sfx.component.processor;

import com.sfx.component.Processor;

public class BasicProcessor implements Processor {	

	@Override
	public String componentType() {
		return "Basic Processor";
	}

	@Override
	public int price() {
		return 17000;
	}

}
