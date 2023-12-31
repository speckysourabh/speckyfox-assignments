package com.sfx.mp;

import java.util.Optional;

public class MaintenanceProcedureFactory {

	public static Optional<MaintenanceProcedure> getMaintanenceProcedure(int maintenanceProcedure) {
		Optional<MaintenanceProcedure> obj;
		switch (maintenanceProcedure) {
		case 1: {
			obj = Optional.ofNullable(new EngineCleanProcudure());
			break;
		}
		case 2: {
			obj = Optional.ofNullable(new OilChangeProcedure());
			break;
		}
		default: {
			obj = Optional.empty();
		}
		}
		return obj;
	}

}
