package com.sfx.bundles;

import java.util.List;

import com.sfx.enums.BundleENUM;
import com.sfx.exception.CustomException;

public class BeginnerBundleFactory {

	public static GamingConsoleBundle buildBundle(BundleENUM bundleType) {
		GamingConsoleBundle gamingConsoleBundle = null;
		switch (bundleType) {
		case GROUP1: {
			gamingConsoleBundle = new BeginnerBundle("STANDARD", "BASIC", "HD");
			break;
		}
		case GROUP2: {
			gamingConsoleBundle = new BeginnerBundle("STANDARD", "BASIC", "4K");
			break;
		}
		default: {
			throw new CustomException("Bundle not find !");
		}
		}
		return gamingConsoleBundle;
	}

	public static List<GamingConsoleBundle> getBundle() {
		return List.of(new BeginnerBundle("STANDARD", "BASIC", "HD"),
				new BeginnerBundle("STANDARD", "BASIC", "4K"));
	}

}
