package com.sfx.abtractFactory;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.pojo.GamingConsole;

public class AverageGamerBundle implements GamingConsoleBundle {
	
	private String controller;
	private String processor;
	private String display;

	public AverageGamerBundle(String controller, String processor, String display) {
		super();
		this.controller = controller;
		this.processor = processor;
		this.display = display;
	}

	@Override
	public GamingConsole getBundle() {
		return GamingConsoleBuilder.builder().controller(controller).processor(processor).display(display).build();
	}

}
