package com.sfx.pojo;

import com.sfx.component.controller.Controller;
import com.sfx.component.display.Display;
import com.sfx.component.processor.Processor;

public class GamingConsole {

	private Processor processor;
	private Display display;
	private Controller controller;
	
	public GamingConsole() {
		super();
	}
	public GamingConsole(Processor processor, Display display, Controller controller) {
		super();
		this.processor = processor;
		this.display = display;
		this.controller = controller;
	}
	public Processor getProcessor() {
		return processor;
	}
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	public Display getDisplay() {
		return display;
	}
	public void setDisplay(Display display) {
		this.display = display;
	}
	public Controller getController() {
		return controller;
	}
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	public String showComponent() {
		return "[ Processor: "+processor.processorType()+", Controller: "+controller.controllerType()+", Display: "+display.displayType()+" ]";
	}
	
	public int showPrice() {
		return processor.price()+controller.price()+display.price();
	}
	
}
