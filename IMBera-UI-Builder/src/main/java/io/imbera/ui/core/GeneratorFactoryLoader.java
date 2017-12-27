package io.imbera.ui.core;

import static io.imbera.ui.core.logging.ErrorCode.ASF01;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.reflections.Reflections;

import com.imbera.demo.executors.AbstractExecutor;

import io.imbera.ui.core.generators.FormDefinitionGenerator;
import io.imbera.ui.core.logging.IMBeraLogger;

final class GeneratorFactoryLoader {
	private static final List<String> PACKAGESCAN_GENERATOR = Stream.of("io.imbera.ui.core.generators").collect(Collectors.toList());
	private static Reflections reflections_generator = new Reflections(PACKAGESCAN_GENERATOR);
	
	private static final List<String> PACKAGESCAN_EXECUTORS = Stream.of("com.imbera.demo.executors").collect(Collectors.toList());
	private static Reflections reflections_Executors = new Reflections(PACKAGESCAN_EXECUTORS);
	
	void load() {
		reflections_generator.getSubTypesOf(FormDefinitionGenerator.class).forEach(instance::registerGenerator);
		reflections_Executors.getSubTypesOf(AbstractExecutor.class).forEach(instance::registerExecuotrs);
	}

	private void registerGenerator(Class<? extends FormDefinitionGenerator> subType) {
		try {
			FormDefinitionGenerator formDefinitionGenerator = subType.newInstance();
			FormDefinitionGeneratorFactory.getInstance().register(formDefinitionGenerator::getAnnotation,formDefinitionGenerator);
		} catch (InstantiationException | IllegalAccessException e) {
			IMBeraLogger.getLogger().error(ASF01, e);
		}
	}
	
	private void registerExecuotrs(Class<? extends AbstractExecutor> subType) {
		try {
			AbstractExecutor abstractExecutor = subType.newInstance();
			ExecutorsRegisterFactory.getInstance().register(abstractExecutor.getClass());
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
