package com.sfx.decorator;

import com.sfx.bundles.GamingConsoleBundle;
import com.sfx.component.Processor;
import com.sfx.factory.ProcessorFactory;

public class ProcessorDecorator extends GamingConsoleDecorator {
	
	private Processor processor;
	private GamingConsoleBundle gamingConsoleBundle;
	private ProcessorFactory processorFactory = new ProcessorFactory();

	public ProcessorDecorator(String processor, GamingConsoleBundle gamingConsoleBundle) {
		super();
		this.processor = this.processorFactory.getProcessor(processor);
		this.gamingConsoleBundle = gamingConsoleBundle;
		
	}

	@Override
	public GamingConsoleBundle getBundle() {
		gamingConsoleBundle.getGamingConsole().setProcessor(processor);
		return this.gamingConsoleBundle;
	}

}
