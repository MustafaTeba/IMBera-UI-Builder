package io.imbera.ui.core;

import static io.imbera.ui.core.logging.ErrorCode.ASF01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reflections.Reflections;

import io.imbera.ui.core.generators.FormDefinitionGenerator;
import io.imbera.ui.core.logging.IMBeraLogger;

final class GeneratorFactoryLoader {
	private static final List<String> PACKAGESCAN = Stream.of("io.imbera.ui.core.generators", "io.imbera.ui.addons.generators").collect(Collectors.toList());
	private static Reflections reflections = new Reflections(PACKAGESCAN);

	void load() {
		reflections.getSubTypesOf(FormDefinitionGenerator.class).forEach(instance::register);
	}

	private void register(Class<? extends FormDefinitionGenerator> subType) {
		try {
			FormDefinitionGenerator formDefinitionGenerator = subType.newInstance();
			FormDefinitionGeneratorFactory.getInstance().register(formDefinitionGenerator::getAnnotation,formDefinitionGenerator);
		} catch (InstantiationException | IllegalAccessException e) {
			IMBeraLogger.getLogger().error(ASF01, e);
		}
	}

	void unload() {
		IMBeraLogger.getLogger().info("I'm unloader");
	}

	static GeneratorFactoryLoader getInstance() {
		if (instance == null)
			instance = new GeneratorFactoryLoader();
		return instance;
	}

	private static GeneratorFactoryLoader instance;

	private GeneratorFactoryLoader() {
	}

}
