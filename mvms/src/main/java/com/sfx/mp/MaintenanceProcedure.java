package com.sfx.mp;

import com.sfx.vehicle.Vehicle;

public interface MaintenanceProcedure {
	void performProcedure(Vehicle vehicle);
	int procedureCharge(Vehicle vehicle);
}
