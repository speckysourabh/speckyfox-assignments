package com.sfx;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sfx.builder.GamingConsoleBuilder;
import com.sfx.component.controller.Controller;
import com.sfx.component.display.Display;
import com.sfx.component.processor.Processor;
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
			List<GamingConsole> gamingConsoles = GamingConsoleSingleton.getInstance().getGamingConsoleBundles();
			IntStream.range(0, gamingConsoles.size()).forEach(
					e -> System.out.println(e + 1 + ". " + gamingConsoles.get(e).showComponent()));
			int bundleChoice = scanner.nextInt() - 1;
			purchasedBunde(gamingConsoles.get(bundleChoice));
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
				.forEach(e -> System.out.println(e + 1 + ". " + displays.get(e).displayType()));
		int displayChoice = scanner.nextInt();
		String display = displayFactory.displayMap().get(displayChoice);
		
		consoleBuilder.display(display);

		ProcessorFactory processorFactory = new ProcessorFactory();
		System.out.println("Choose a processor :");
		List<Processor> processors = processorFactory.processors();
		IntStream.range(0, processors.size())
				.forEach(e -> System.out.println(e + 1 + ". " + processors.get(e).processorType()));
		int processorChoice = scanner.nextInt();
		String processor = processorFactory.processorMap().get(processorChoice);
		
		consoleBuilder.processor(processor);

		ControllerFactory controllerFactory = new ControllerFactory();
		System.out.println("Choose a controller :");
		List<Controller> controllers = controllerFactory.controllers();
		IntStream.range(0, controllers.size())
				.forEach(e -> System.out.println(e + 1 + ". " + controllers.get(e).controllerType()));
		int controllerChoice = scanner.nextInt();
		String controller = controllerFactory.controllerMap().get(controllerChoice);
		
		consoleBuilder.controller(controller);

		purchasedBunde(consoleBuilder.build());
	}

}
