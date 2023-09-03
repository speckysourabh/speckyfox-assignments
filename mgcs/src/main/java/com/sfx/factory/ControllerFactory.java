package com.sfx.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sfx.component.controller.Controller;
import com.sfx.component.controller.MotionSensingController;
import com.sfx.component.controller.ProController;
import com.sfx.component.controller.StandardController;
import com.sfx.exception.CustomException;

public class ControllerFactory {

	public Controller getController(String controllerType) {
		
		if(controllerType == null) {
			throw new CustomException("You have chosen a wrong controller type");
		}
		
		Controller controller;
		switch (controllerType.toUpperCase()) {
		case "PRO": {
			controller = new ProController();
			break;
		}
		case "MOTION_SENSING": {
			controller = new MotionSensingController();
			break;
		}
		case "STANDARD": {
			controller = new StandardController();
			break;
		}
		default: {
			throw new CustomException("Controller not find");
		}
		}
		return controller;
	}

	public Map<Integer, String> controllerMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "PRO");
		map.put(2, "MOTION_SENSING");
		map.put(3, "STANDARD");
		return map;
	}
	
	public List<Controller> controllers() {
		return List.of(new ProController(), new MotionSensingController(), new StandardController());
	}

}
