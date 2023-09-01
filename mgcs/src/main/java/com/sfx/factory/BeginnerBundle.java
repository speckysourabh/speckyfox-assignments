package com.sfx.factory;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.pojo.GamingConsole;

public class BeginnerBundle implements GamingConsoleBundle {

	@Override
	public GamingConsole getInstance() {
		return GamingConsoleBuilder.builder().controller("STANDARD").processor("BASIC").display("HD").build();
	}

}
