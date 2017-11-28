package io.imbera.ui.core.schema;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.executors.AbstractOnloadExecutor;
import com.imbera.demo.menu.UIMenu;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.FormDefinitionGeneratorFactory;
import io.imbera.ui.core.form.IMBeraFormDef;
import io.imbera.ui.core.form.IMBeraMenuDef;
import io.imbera.ui.dto.UiForm;

public final class UiFormSchemaGenerator {

	private static UiFormSchemaGenerator instance;

	public ObjectNode generateForm(UIContainer form) throws JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode formDefinition = mapper.createObjectNode();
		onLoadExecutors(form);
		initFormDefinition(mapper, form , formDefinition);
		return formDefinition;
	}
	
	public ObjectNode generateMenu(UIMenu menu) throws JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode menuDef = mapper.createObjectNode();
		Optional<IMBeraMenuDef> IMBeraMenuDef = Optional.ofNullable(menu.getClass().getAnnotation(IMBeraMenuDef.class));
		IMBeraMenuDef.ifPresent(annotation -> {
			FormDefinitionGeneratorFactory.getInstance().getGenerator(annotation.annotationType().getName())
					.ifPresent(generator -> generator.generate(mapper, menuDef, menu, null));
		});
		return menuDef;
	}

	private void onLoadExecutors(UIContainer form){
		Optional<IMBeraFormDef> IMBeraFormDef = Optional.ofNullable(form.getClass().getAnnotation(IMBeraFormDef.class));
		IMBeraFormDef.ifPresent(formDef -> {
			Arrays.stream(formDef.onLoadExecutors()).forEach(executor->{
				try {
					AbstractOnloadExecutor abstractOnloadExecutor = executor.getExecutorClass().getConstructor().newInstance();
					abstractOnloadExecutor.setExecutorForm(form).doBussiness(); 
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException	| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
				}
				
			}); 
		});
	}
	private void initFormDefinition(ObjectMapper mapper, UIContainer form,ObjectNode formDefinition) {
		Optional<IMBeraFormDef> IMBeraFormDef = Optional.ofNullable(form.getClass().getAnnotation(IMBeraFormDef.class));
		IMBeraFormDef.ifPresent(annotation -> {
			FormDefinitionGeneratorFactory.getInstance().getGenerator(annotation.annotationType().getName())
					.ifPresent(generator -> generator.generate(mapper, formDefinition, form, null));
		});

	}

	public static UiFormSchemaGenerator get() {
		if (instance == null) {
			instance = new UiFormSchemaGenerator();
		}
		return instance;
	}

	private UiFormSchemaGenerator() {
	}
}
