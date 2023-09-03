package com.sfx.abtractFactory;

import java.util.List;

import com.sfx.enums.BundleENUM;
import com.sfx.exception.CustomException;
import com.sfx.pojo.GamingConsole;

public class BeginnerBundleFactory {

	public static GamingConsole buildBundle(BundleENUM bundleType) {
		GamingConsole gamingConsole = null;
		switch (bundleType) {
		case GROUP1: {
			gamingConsole = new BeginnerBundle("STANDARD", "BASIC", "HD").getBundle();
			break;
		}
		case GROUP2: {
			gamingConsole = new BeginnerBundle("STANDARD", "BASIC", "4K").getBundle();
			break;
		}
		default: {
			throw new CustomException("Bundle not find !");
		}
		}
		return gamingConsole;
	}

	public static List<GamingConsole> getBundle() {
		return List.of(new BeginnerBundle("STANDARD", "BASIC", "HD").getBundle(),
				new BeginnerBundle("STANDARD", "BASIC", "4K").getBundle());
	}

}
