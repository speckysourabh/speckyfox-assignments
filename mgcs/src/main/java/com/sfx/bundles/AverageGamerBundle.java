package com.sfx.bundles;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.pojo.GamingConsole;

public class AverageGamerBundle implements GamingConsoleBundle {
	
	private GamingConsole gamingConsole;

	public AverageGamerBundle(String controller, String processor, String display) {
		super();
		this.gamingConsole = GamingConsoleBuilder.builder().controller(controller).processor(processor).display(display).build();
	}

	@Override
	public GamingConsoleBundle getBundle() {
		return this;
	}

	@Override
	public GamingConsole getGamingConsole() {
		return this.gamingConsole;
	}

}
