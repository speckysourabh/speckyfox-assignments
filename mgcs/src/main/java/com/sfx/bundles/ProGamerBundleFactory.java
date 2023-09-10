package com.sfx.bundles;

import java.util.List;

import com.sfx.enums.BundleENUM;
import com.sfx.exception.CustomException;

public class ProGamerBundleFactory {

	public static GamingConsoleBundle buildBundle(BundleENUM bundleType) {
		GamingConsoleBundle gamingConsoleBundle = null;
		switch (bundleType) {
		case GROUP1: {
			gamingConsoleBundle = new ProGamerBundle("MOTION_SENSING", "PRO_GAMING", "8K");
			break;
		}
		case GROUP2: {
			gamingConsoleBundle = new ProGamerBundle("PRO", "PRO_GAMING", "8K");
			break;
		}
		default: {
			throw new CustomException("Bundle not find !");
		}
		}
		return gamingConsoleBundle;
	}

	public static List<GamingConsoleBundle> getBundle() {
		return List.of(new ProGamerBundle("MOTION_SENSING", "PRO_GAMING", "8KVR"),
				new ProGamerBundle("PRO", "PRO_GAMING", "8KVR"));
	}

}
