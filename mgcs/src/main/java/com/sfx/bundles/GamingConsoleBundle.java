package com.sfx.bundles;

import com.sfx.pojo.GamingConsole;

public interface GamingConsoleBundle {

	GamingConsoleBundle getBundle();
	default GamingConsole getGamingConsole() {
		return new GamingConsole();
	}
	
}
