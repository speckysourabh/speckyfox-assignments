package com.sfx.decorator;

import com.sfx.bundles.GamingConsoleBundle;
import com.sfx.component.Controller;
import com.sfx.factory.ControllerFactory;

public class ControllerDecorator extends GamingConsoleDecorator {
	
	private Controller controller;
	private GamingConsoleBundle gamingConsoleBundle;
	private ControllerFactory controllerFactory = new ControllerFactory();

	public ControllerDecorator(String controller, GamingConsoleBundle gamingConsoleBundle) {
		super();
		this.controller = this.controllerFactory.getController(controller);
		this.gamingConsoleBundle = gamingConsoleBundle;
	}

	@Override
	public GamingConsoleBundle getBundle() {
		gamingConsoleBundle.getGamingConsole().setController(controller);
		return this.gamingConsoleBundle;
	}

}
