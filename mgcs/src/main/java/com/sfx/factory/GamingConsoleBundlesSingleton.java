package com.sfx.factory;

import java.util.List;

public class GamingConsoleBundlesSingleton {
	
	private static GamingConsoleBundlesSingleton bundlesSingleton;
	private static List<GamingConsoleBundle> bundles;
	
	private GamingConsoleBundlesSingleton() {
		bundles = List.of(new AverageGamerBundle(), new BeginnerBundle(), new ProGamerBundle());
	}

	public List<GamingConsoleBundle> getGamingConsoleBundles() {
		return bundles;
	}
	
	public static GamingConsoleBundlesSingleton getInstance() {
		if(bundlesSingleton==null) {
			bundlesSingleton = new GamingConsoleBundlesSingleton();
		}
		return bundlesSingleton;
	}
	
}
