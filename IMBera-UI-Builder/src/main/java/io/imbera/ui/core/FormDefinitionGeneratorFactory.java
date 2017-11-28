package io.imbera.ui.core;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import io.imbera.ui.core.generators.FormDefinitionGenerator;

public final class FormDefinitionGeneratorFactory {

	public Optional<FormDefinitionGenerator> getGenerator(String annotationName) {
		return Optional.ofNullable(GENERATORS.get(annotationName));
	}

	void register(Supplier<String> annotationName, FormDefinitionGenerator generator) {
		GENERATORS.put(annotationName.get(), generator);
	}

	public static FormDefinitionGeneratorFactory getInstance() {
		if (instance == null) {
			instance = new FormDefinitionGeneratorFactory();
		}
		return instance;
	}

	private static final Map<String, FormDefinitionGenerator> GENERATORS = new ConcurrentHashMap<>();

	private static FormDefinitionGeneratorFactory instance;

	private FormDefinitionGeneratorFactory() {
	}
}
