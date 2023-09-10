package com.sfx.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfx.component.Display;
import com.sfx.component.display.Display4k;
import com.sfx.component.display.Display8kVR;
import com.sfx.component.display.DisplayHD;
import com.sfx.exception.CustomException;

public class DisplayFactory {

	public Display getDisplay(String displayType) {
		Display display;
		
		if(displayType == null) {
			throw new CustomException("You have chosen a wrong display type");
		}
		
		switch (displayType.toUpperCase()) {
		case "HD": {
			display = new DisplayHD();
			break;
		}
		case "4K": {
			display = new Display4k();
			break;
		}
		case "8KVR": {
			display = new Display8kVR();
			break;
		}
		default: {
			throw new CustomException("Display not find");
		}
		}
		return display;
	}
	
	public Map<Integer, String> displayMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "HD");
		map.put(2, "4K");
		map.put(3, "8KVR");
		return map;
	}

	public List<Display> displays() {
		return List.of(new DisplayHD(), new Display4k(), new Display8kVR());
	}

}
