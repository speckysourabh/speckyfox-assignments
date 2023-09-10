package com.sfx.decorator;

import com.sfx.bundles.GamingConsoleBundle;
import com.sfx.component.Display;
import com.sfx.factory.DisplayFactory;

public class DisplayDecorator extends GamingConsoleDecorator {
	private Display display;
	private GamingConsoleBundle gamingConsoleBundle;
	private DisplayFactory displayFactory = new DisplayFactory();

	public DisplayDecorator(String display, GamingConsoleBundle gamingConsoleBundle) {
		super();
		this.display = this.displayFactory.getDisplay(display);
		this.gamingConsoleBundle = gamingConsoleBundle;
	}

	@Override
	public GamingConsoleBundle getBundle() {
		gamingConsoleBundle.getGamingConsole().setDisplay(display);
		return this.gamingConsoleBundle;
	}
}
