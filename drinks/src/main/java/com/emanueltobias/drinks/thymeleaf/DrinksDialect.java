package com.emanueltobias.drinks.thymeleaf;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import com.emanueltobias.drinks.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.emanueltobias.drinks.thymeleaf.processor.MessageElementTagProcessor;

public class DrinksDialect extends AbstractProcessorDialect{
	
	public DrinksDialect() {
		super("EmanuelTobias Drinks", "drinks", StandardDialect.PROCESSOR_PRECEDENCE);
	}

	@Override
	public Set<IProcessor> getProcessors(String dialectPrefix) {
		final Set<IProcessor> processadores = new HashSet<>();
		processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
		processadores.add(new MessageElementTagProcessor(dialectPrefix));
		return processadores;
	}

}
