package com.sfx.component.controller;

import com.sfx.component.Controller;

public class MotionSensingController implements Controller {

	@Override
	public int price() {
		return 15000;
	}

	@Override
	public String componentType() {
		return "Motion Sensing Controller";
	}

}
