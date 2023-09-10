package com.sfx.factory;

import java.util.ArrayList;
import java.util.List;

import com.sfx.bundles.AverageBundleFactory;
import com.sfx.bundles.BeginnerBundleFactory;
import com.sfx.bundles.GamingConsoleBundle;
import com.sfx.bundles.ProGamerBundleFactory;

public class GamingConsoleSingleton {
	
	private static GamingConsoleSingleton bundlesSingleton;
	private static List<GamingConsoleBundle> bundles;
	
	private GamingConsoleSingleton() {
		
		bundles = new ArrayList<GamingConsoleBundle>();
		bundles.addAll(BeginnerBundleFactory.getBundle());
		bundles.addAll(AverageBundleFactory.getBundle());
		bundles.addAll(ProGamerBundleFactory.getBundle());
	}

	public List<GamingConsoleBundle> getGamingConsoleBundles() {
		return bundles;
	}
	
	public static GamingConsoleSingleton getInstance() {
		if(bundlesSingleton==null) {
			bundlesSingleton = new GamingConsoleSingleton();
		}
		return bundlesSingleton;
	}
	
}
