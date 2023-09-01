package com.sfx.component.processor;

public class BasicProcessor implements Processor {	

	@Override
	public String processorType() {
		return "Basic Processor";
	}

	@Override
	public int price() {
		return 17000;
	}

}
