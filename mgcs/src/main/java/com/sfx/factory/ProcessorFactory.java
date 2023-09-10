package com.sfx.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfx.component.Processor;
import com.sfx.component.processor.AdvancedProcessor;
import com.sfx.component.processor.BasicProcessor;
import com.sfx.component.processor.ProGamingProcessor;
import com.sfx.exception.CustomException;

public class ProcessorFactory {

	public Processor getProcessor(String processorType) {
		
		if(processorType == null) {
			throw new CustomException("You have chosen a wrong processor type");
		}
		
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
			throw new CustomException("Processor not find");
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
