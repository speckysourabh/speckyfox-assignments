package com.sfx.component.processor;

public class AdvancedProcessor implements Processor {

	@Override
	public String processorType() {
		return "Advanced Processor";
	}

	@Override
	public int price() {
		return 20000;
	}

}
