package com.sfx.bundles;

import java.util.List;

import com.sfx.enums.BundleENUM;
import com.sfx.exception.CustomException;

public class AverageBundleFactory {

	public static GamingConsoleBundle buildBundle(BundleENUM bundleType) {

		GamingConsoleBundle gamingConsoleBundle = null;
		switch (bundleType) {
		case GROUP1: {
			gamingConsoleBundle = new AverageGamerBundle("STANDARD", "ADVANCED", "HD");
			break;
		}
		case GROUP2: {
			gamingConsoleBundle = new AverageGamerBundle("MOTION_SENSING", "ADVANCED", "4K");
			break;
		}
		default:
			throw new CustomException("Bundle not find !");
		}
		return gamingConsoleBundle;
	}

	public static List<GamingConsoleBundle> getBundle() {
		return List.of(new AverageGamerBundle("STANDARD", "ADVANCED", "HD"),
				new AverageGamerBundle("MOTION_SENSING", "ADVANCED", "4K"));
	}

}
