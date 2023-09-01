package com.sfx.factory;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.pojo.GamingConsole;

public class ProGamerBundle implements GamingConsoleBundle {
	@Override
	public GamingConsole getInstance() {
		return GamingConsoleBuilder.builder().controller("PRO").processor("PRO_GAMING").display("8KVR").build();
	}
}
