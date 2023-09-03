package com.sfx.abtractFactory;

import java.util.List;

import com.sfx.enums.BundleENUM;
import com.sfx.exception.CustomException;
import com.sfx.pojo.GamingConsole;

public class ProGamerBundleFactory {

	public static GamingConsole buildBundle(BundleENUM bundleType) {
		GamingConsole gamingConsole = null;
		switch (bundleType) {
		case GROUP1: {
			gamingConsole = new ProGamerBundle("MOTION_SENSING", "PRO_GAMING", "8K").getBundle();
			break;
		}
		case GROUP2: {
			gamingConsole = new ProGamerBundle("PRO", "PRO_GAMING", "8K").getBundle();
			break;
		}
		default: {
			throw new CustomException("Bundle not find !");
		}
		}
		return gamingConsole;
	}

	public static List<GamingConsole> getBundle() {
		return List.of(new ProGamerBundle("MOTION_SENSING", "PRO_GAMING", "8KVR").getBundle(),
				new ProGamerBundle("PRO", "PRO_GAMING", "8KVR").getBundle());
	}

}
