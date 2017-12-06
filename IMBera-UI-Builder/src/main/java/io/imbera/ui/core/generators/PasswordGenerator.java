package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Password;

public class PasswordGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition,UIContainer form, Field field) {
		Password annotation = field.getAnnotation(Password.class);
		
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldsExecutors(mapper,fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		String fieldAddonLeft = annotation.fieldAddonLeft();
		if (!fieldAddonLeft.isEmpty()) {
			fieldFormDefinition.put("fieldAddonLeft", fieldAddonLeft);
		}
		String fieldAddonRight = annotation.fieldAddonRight();
		if (!fieldAddonRight.isEmpty()) {
			fieldFormDefinition.put("fieldAddonRight", fieldAddonRight);
		}
		
		String validationMessage = annotation.validationMessage();
		if (!validationMessage.isEmpty()) {
			fieldFormDefinition.put("validationMessage", validationMessage);
		}
	}

	@Override
	public String getAnnotation() {
		return Password.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return Password.class.getSimpleName();
	}
}
