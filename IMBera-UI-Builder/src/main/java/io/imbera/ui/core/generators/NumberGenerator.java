package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Number;

public class NumberGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition,UIContainer form, Field field) {
		Number annotation = field.getAnnotation(Number.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldIMBeraExecutors(mapper,fieldFormDefinition, annotation.executor());
		buildFieldValue(fieldFormDefinition, form, field);
		String fieldAddonLeft = annotation.fieldAddonLeft();
		if (!fieldAddonLeft.isEmpty())
			fieldFormDefinition.put("fieldAddonLeft", fieldAddonLeft);
		String fieldAddonRight = annotation.fieldAddonRight();
		if (!fieldAddonRight.isEmpty()) 
			fieldFormDefinition.put("fieldAddonRight", fieldAddonRight);
	}

	@Override
	public String getAnnotation() {
		return Number.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return Number.class.getSimpleName();
	}
}
