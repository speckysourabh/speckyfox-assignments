package com.sfx.component.controller;

public class MotionSensingController implements Controller {

	@Override
	public String controllerType() {
		return "Motion Sensing Controller";
	}

	@Override
	public int price() {
		return 1500;
	}

}
