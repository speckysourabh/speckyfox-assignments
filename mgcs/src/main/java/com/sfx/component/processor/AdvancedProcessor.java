package com.sfx.component.processor;

import com.sfx.component.Processor;

public class AdvancedProcessor implements Processor {

	@Override
	public String componentType() {
		return "Advanced Processor";
	}

	@Override
	public int price() {
		return 20000;
	}

}
