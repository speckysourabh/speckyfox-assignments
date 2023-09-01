package com.sfx.component.processor;

public class ProGamingProcessor implements Processor {
	
	@Override
	public String processorType() {
		return "Pro Gaming Processor";
	}

	@Override
	public int price() {
		return 35000;
	}

}
