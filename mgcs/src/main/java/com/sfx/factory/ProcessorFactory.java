package com.sfx.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfx.component.processor.AdvancedProcessor;
import com.sfx.component.processor.BasicProcessor;
import com.sfx.component.processor.ProGamingProcessor;
import com.sfx.component.processor.Processor;

public class ProcessorFactory {

	public Processor getProcessor(String processorType) {
		Processor processor;
		switch (processorType.toUpperCase()) {
		case "BASIC": {
			processor = new BasicProcessor();
			break;
		}
		case "ADVANCED": {
			processor = new AdvancedProcessor();
			break;
		}
		case "PRO_GAMING": {
			processor = new ProGamingProcessor();
			break;
		}
		default: {
			processor = null;
		}
		}
		return processor;
	}
	
	public Map<Integer, String> processorMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "BASIC");
		map.put(2, "ADVANCED");
		map.put(3, "PRO_GAMING");
		return map;
	}

	public List<Processor> processors() {
		return List.of(new BasicProcessor(), new AdvancedProcessor(), new ProGamingProcessor());
	}

}
