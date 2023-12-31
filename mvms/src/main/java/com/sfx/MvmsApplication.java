package com.sfx;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sfx.mp.MaintenanceProcedure;
import com.sfx.mp.MaintenanceProcedureFactory;
import com.sfx.pojo.Customer;
import com.sfx.pojo.GeneralCustomer;
import com.sfx.pojo.VipCustomer;
import com.sfx.util.CustomerUtil;
import com.sfx.vehicle.Vehicle;
import com.sfx.vehicle.VehicleDb;
import com.sfx.vehicle.VehicleFactory;

@SpringBootApplication
public class MvmsApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(MvmsApplication.class);
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(MvmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Welcome to \"Modular Vehicle Management System\"");
		LOGGER.info("Enter your name :");
		String customerName = scanner.nextLine();
		LOGGER.info("Enter your mobile number :");
		Long mobNumber = scanner.nextLong();
		LOGGER.info("Enter your email :");
		String email = scanner.next();

		Customer customer;

		if (CustomerUtil.isCustomerVIP(email)) {
			customer = new VipCustomer(customerName, mobNumber, email, email);
		} else {
			customer = new GeneralCustomer(customerName, mobNumber, email, email);
		}

		LOGGER.info("Choose an option : ");
		LOGGER.info("1 - Inquiry ");
		LOGGER.info("2 - Maintenance ");

		switch (scanner.nextInt()) {
		case 1: {
			customerInquiry(customer);
			break;
		}
		case 2: {
			maintenance();
			break;
		}
		default: {
			LOGGER.info("Invalid Option");
		}
		}

	}

	private void maintenance() throws Exception {

		Vehicle vehicle = createVehicle();

		LOGGER.info("Choose maintenance procedure :");
		LOGGER.info("1. Engine Cleaning");
		LOGGER.info("2. Oil Change");
		int mp = scanner.nextInt();

		MaintenanceProcedure maintanenceProcedure = MaintenanceProcedureFactory.getMaintanenceProcedure(mp)
				.orElseThrow(() -> new Exception("No procedure found"));

		LOGGER.info("Your maintenance charge is {}", vehicle.calculateMaintenancePrice(maintanenceProcedure));
	}

	private Vehicle createVehicle() throws Exception {
		LOGGER.info("Enter vehicle type :");
		String vehicleType = scanner.next();
		LOGGER.info("Enter your vehicle model :");
		String vehicleModel = scanner.next().toLowerCase();
		LOGGER.info("Enter vehicle make :");
		String vehicleMake = scanner.next();
		LOGGER.info("Enter vehicle year :");
		int vehicleYear = scanner.nextInt();
		LOGGER.info("Enter vehicle price :");
		double vehiclePrice = scanner.nextDouble();

		Vehicle vehicle = VehicleFactory.getVehicle(vehicleType).orElseThrow(() -> new Exception("No vehicle present"));
		vehicle.setMake(vehicleMake);
		vehicle.setModel(vehicleModel);
		vehicle.setPrice(vehiclePrice);
		vehicle.setYear(vehicleYear);
		vehicle.setVehicleType(vehicleType);
		return vehicle;
	}

	public void customerInquiry(Customer customer) throws Exception {
		LOGGER.info("Enter vehicle type :");
		String vehicleType = scanner.next();
		List<Vehicle> vehicles = VehicleDb.getAll(vehicleType);
		LOGGER.info("Choose an option :");
		LOGGER.info("1. Veiw vehicles");
		LOGGER.info("2. Take a drive");
		LOGGER.info("3. Print maintenance invoice");
		switch (scanner.nextInt()) {
		case 1: {
			LOGGER.info(vehicles.toString());
			break;
		}
		case 2: {
			LOGGER.info("Select a vehicle to derive");
			IntStream.range(0, vehicles.size()).forEach(i -> LOGGER.info("{}. {}", i, vehicles.get(i).getModel()));
			int choice = scanner.nextInt();
			LOGGER.info("{} driving {}", customer.getName(), vehicles.get(choice).getModel());
			break;
		}
		case 3: {
			Vehicle vehicle = createVehicle();
			LOGGER.info("Choose maintenance procedure :");
			LOGGER.info("1. Engine Cleaning");
			LOGGER.info("2. Oil Change");
			int mp = scanner.nextInt();

			MaintenanceProcedure maintanenceProcedure = MaintenanceProcedureFactory.getMaintanenceProcedure(mp)
					.orElseThrow(() -> new Exception("No procedure found"));

			LOGGER.info("{}", vehicle.calculateMaintenancePrice(maintanenceProcedure));

		}
		}
	}

}
