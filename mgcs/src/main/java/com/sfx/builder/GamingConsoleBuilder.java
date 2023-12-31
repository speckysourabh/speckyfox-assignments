package com.sfx.builder;

import com.sfx.component.Controller;
import com.sfx.component.Display;
import com.sfx.component.Processor;
import com.sfx.factory.ControllerFactory;
import com.sfx.factory.DisplayFactory;
import com.sfx.factory.ProcessorFactory;
import com.sfx.pojo.GamingConsole;

public class GamingConsoleBuilder {

	private GamingConsole console = new GamingConsole();
	
	ProcessorFactory processorFactory = new ProcessorFactory();
	DisplayFactory displayFactory = new DisplayFactory();
	ControllerFactory controllerFactory = new ControllerFactory();

	public GamingConsoleBuilder processor(String processorType) {
		Processor processor = processorFactory.getProcessor(processorType);
		console.setProcessor(processor);
		return this;
	}

	public GamingConsoleBuilder display(String displayType) {
		Display display = displayFactory.getDisplay(displayType);
		console.setDisplay(display);
		return this;
	}

	public GamingConsoleBuilder controller(String controllerType) {
		Controller controller = controllerFactory.getController(controllerType);
		console.setController(controller);
		return this;
	}

	public static GamingConsoleBuilder builder() {
		return new GamingConsoleBuilder();
	}

	public GamingConsole build() {
		return this.console;
	}

}
