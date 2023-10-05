package com.sfx;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.bundles.GamingConsoleBundle;
import com.sfx.component.Controller;
import com.sfx.component.Display;
import com.sfx.component.Processor;
import com.sfx.decorator.ControllerDecorator;
import com.sfx.decorator.DisplayDecorator;
import com.sfx.decorator.GamingConsoleDecorator;
import com.sfx.decorator.ProcessorDecorator;
import com.sfx.factory.ControllerFactory;
import com.sfx.factory.DisplayFactory;
import com.sfx.factory.GamingConsoleSingleton;
import com.sfx.factory.ProcessorFactory;
import com.sfx.pojo.GamingConsole;

@SpringBootApplication
public class MgcsApplication implements CommandLineRunner {

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(MgcsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Welcome to \"Modular Gaming Console System\"");
		System.out.println("Choose an option :");
		System.out.println("1. Bundled Console Gaming System");
		System.out.println("2. Customized Console Gaming System");

		switch (scanner.nextInt()) {
		case 1: {
			System.out.println("Choose an gaming console bundles from below options :");
			List<GamingConsoleBundle> gamingConsoles = GamingConsoleSingleton.getInstance().getGamingConsoleBundles();
			IntStream.range(0, gamingConsoles.size()).forEach(
					e -> System.out.println(e + 1 + ". " + gamingConsoles.get(e).getBundle().getGamingConsole().showComponent()));
			int bundleChoice = scanner.nextInt() - 1;
			GamingConsoleBundle gamingConsole = gamingConsoles.get(bundleChoice).getBundle();
			purchasedBunde(gamingConsole.getBundle().getGamingConsole());
			System.out.println("Do you want to upgrade ?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			int choice = scanner.nextInt();
			if(choice == 1) {
				upgradeConsole(gamingConsole);
			}
			break;
		}
		case 2: {
			System.out.println("Let's build your gaming console !");
			createCustomConsole();
			break;
		}
		default: {
			System.out.println("Wrong choice !");
		}
		}
	}

	public void upgradeConsole(GamingConsoleBundle gamingConsoleBundle) {
		System.out.println("Do you want to upgrade controller");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int choice = scanner.nextInt();
		if(choice == 1) {
			ControllerFactory controllerFactory = new ControllerFactory();
			System.out.println("Choose a controller :");
			List<Controller> controllers = controllerFactory.controllers();
			IntStream.range(0, controllers.size())
			.forEach(e -> System.out.println(e + 1 + ". " + controllers.get(e).componentType()));
			int controllerChoice = scanner.nextInt();
			String controller = controllerFactory.controllerMap().get(controllerChoice);
			GamingConsoleDecorator consoleDecorator = new ControllerDecorator(controller, gamingConsoleBundle);
			GamingConsole gamingConsole = consoleDecorator.getBundle().getGamingConsole();
			System.out.println(gamingConsole.showComponent()+" - "+gamingConsole.showPrice());
		}
		
		System.out.println("Do you want to upgrade processor");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int choice2 = scanner.nextInt();
		if(choice2 == 1) {
			ProcessorFactory processorFactory = new ProcessorFactory();
			System.out.println("Choose a processor :");
			List<Processor> processors = processorFactory.processors();
			IntStream.range(0, processors.size())
					.forEach(e -> System.out.println(e + 1 + ". " + processors.get(e).componentType()));
			int processorChoice = scanner.nextInt();
			String processor = processorFactory.processorMap().get(processorChoice);
			GamingConsoleDecorator consoleDecorator = new ProcessorDecorator(processor, gamingConsoleBundle);
			GamingConsole gamingConsole = consoleDecorator.getBundle().getGamingConsole();
			System.out.println(gamingConsole.showComponent()+" - "+gamingConsole.showPrice());
		}
		
		System.out.println("Do you want to upgrade display");
		System.out.println("1. Yes");
		System.out.println("2. No");
		int choice3 = scanner.nextInt();
		if(choice3 == 1) {
			DisplayFactory displayFactory = new DisplayFactory();
			System.out.println("Choose a display :");
			List<Display> displays = displayFactory.displays();
			IntStream.range(0, displays.size())
					.forEach(e -> System.out.println(e + 1 + ". " + displays.get(e).componentType()));
			int displayChoice = scanner.nextInt();
			String display = displayFactory.displayMap().get(displayChoice);
			GamingConsoleDecorator consoleDecorator = new DisplayDecorator(display, gamingConsoleBundle);
			GamingConsole gamingConsole = consoleDecorator.getBundle().getGamingConsole();
			System.out.println(gamingConsole.showComponent()+" - "+gamingConsole.showPrice());
		}
		
		System.out.println("Final setup and price !");
		System.out.println("Setup - "+gamingConsoleBundle.getBundle().getGamingConsole().showComponent());
		System.out.println("Price - "+gamingConsoleBundle.getBundle().getGamingConsole().showPrice());
	}

	public void purchasedBunde(GamingConsole gamingConsole) {
		System.out.println("You have purchased !");
		System.out.println(gamingConsole.showComponent());
		System.out.println("Your total amout to pay is :");
		System.out.println(gamingConsole.showPrice());
	}

	public void createCustomConsole() {
		
		GamingConsoleBuilder consoleBuilder = GamingConsoleBuilder.builder();
		
		DisplayFactory displayFactory = new DisplayFactory();
		System.out.println("Choose a display :");
		List<Display> displays = displayFactory.displays();
		IntStream.range(0, displays.size())
				.forEach(e -> System.out.println(e + 1 + ". " + displays.get(e).componentType()));
		int displayChoice = scanner.nextInt();
		String display = displayFactory.displayMap().get(displayChoice);
		
		consoleBuilder.display(display);

		ProcessorFactory processorFactory = new ProcessorFactory();
		System.out.println("Choose a processor :");
		List<Processor> processors = processorFactory.processors();
		IntStream.range(0, processors.size())
				.forEach(e -> System.out.println(e + 1 + ". " + processors.get(e).componentType()));
		int processorChoice = scanner.nextInt();
		String processor = processorFactory.processorMap().get(processorChoice);
		
		consoleBuilder.processor(processor);

		ControllerFactory controllerFactory = new ControllerFactory();
		System.out.println("Choose a controller :");
		List<Controller> controllers = controllerFactory.controllers();
		IntStream.range(0, controllers.size())
				.forEach(e -> System.out.println(e + 1 + ". " + controllers.get(e).componentType()));
		int controllerChoice = scanner.nextInt();
		String controller = controllerFactory.controllerMap().get(controllerChoice);
		
		consoleBuilder.controller(controller);

		purchasedBunde(consoleBuilder.build());
	}

}
