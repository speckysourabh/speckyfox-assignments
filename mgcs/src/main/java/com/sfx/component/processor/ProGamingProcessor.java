package com.sfx.component.processor;

import com.sfx.component.Processor;

public class ProGamingProcessor implements Processor {
	
	@Override
	public String componentType() {
		return "Pro Gaming Processor";
	}

	@Override
	public int price() {
		return 35000;
	}

}
