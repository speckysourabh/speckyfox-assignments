package com.sfx.abtractFactory;

import java.util.List;

import com.sfx.enums.BundleENUM;
import com.sfx.exception.CustomException;
import com.sfx.pojo.GamingConsole;

public class AverageBundleFactory {

	public static GamingConsole buildBundle(BundleENUM bundleType) {
		GamingConsole gamingConsole = null;
		switch (bundleType) {
		case GROUP1: {
			gamingConsole = new AverageGamerBundle("STANDARD", "ADVANCED", "HD").getBundle();
			break;
		}
		case GROUP2: {
			gamingConsole = new AverageGamerBundle("MOTION_SENSING", "ADVANCED", "4K").getBundle();
			break;
		}
		default: {
			throw new CustomException("Bundle not find !");
		}
		}
		return gamingConsole;
	}

	public static List<GamingConsole> getBundle() {
		return List.of(new AverageGamerBundle("STANDARD", "ADVANCED", "HD").getBundle(),
				new AverageGamerBundle("MOTION_SENSING", "ADVANCED", "4K").getBundle());
	}

}
