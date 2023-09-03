package com.sfx.factory;

import java.util.ArrayList;
import java.util.List;

import com.sfx.abtractFactory.AverageBundleFactory;
import com.sfx.abtractFactory.BeginnerBundleFactory;
import com.sfx.abtractFactory.ProGamerBundleFactory;
import com.sfx.pojo.GamingConsole;

public class GamingConsoleSingleton {
	
	private static GamingConsoleSingleton bundlesSingleton;
	private static List<GamingConsole> bundles;
	
	private GamingConsoleSingleton() {
		
		bundles = new ArrayList<GamingConsole>();
		bundles.addAll(BeginnerBundleFactory.getBundle());
		bundles.addAll(AverageBundleFactory.getBundle());
		bundles.addAll(ProGamerBundleFactory.getBundle());
	}

	public List<GamingConsole> getGamingConsoleBundles() {
		return bundles;
	}
	
	public static GamingConsoleSingleton getInstance() {
		if(bundlesSingleton==null) {
			bundlesSingleton = new GamingConsoleSingleton();
		}
		return bundlesSingleton;
	}
	
}
