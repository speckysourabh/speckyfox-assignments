package com.sfx.factory;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.pojo.GamingConsole;

public class AverageGamerBundle implements GamingConsoleBundle {

	@Override
	public GamingConsole getInstance() {
		return GamingConsoleBuilder.builder().controller("MOTION_SENSING").processor("ADVANCED").display("4K").build();
	}

}
