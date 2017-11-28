package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Password;

public class PasswordGenerator implements FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition,UIContainer form, Field field) {
		Password annotation = field.getAnnotation(Password.class);
		
		buildBasicInfo(fieldFormDefinition, field.getName(),getAnnotationName() , annotation.title(),annotation.colSize() ,annotation.FieldsMap().ordinal());
		buildFieldsExecutors(mapper,fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		
		String description = annotation.description();
		if (!description.isEmpty()) {
			fieldFormDefinition.put("description", description);
		}
		
		String fieldAddonLeft = annotation.fieldAddonLeft();
		if (!fieldAddonLeft.isEmpty()) {
			fieldFormDefinition.put("fieldAddonLeft", fieldAddonLeft);
		}
		
		String fieldAddonRight = annotation.fieldAddonRight();
		if (!fieldAddonRight.isEmpty()) {
			fieldFormDefinition.put("fieldAddonRight", fieldAddonRight);
		}
		
		String placeHolder = annotation.placeHolder();
		if (!placeHolder.isEmpty()) {
			fieldFormDefinition.put("placeholder", placeHolder);
		}
		boolean noTitle = annotation.noTitle();
		if (noTitle) {
			fieldFormDefinition.put("notitle", noTitle);
		}
		String validationMessage = annotation.validationMessage();
		if (!validationMessage.isEmpty()) {
			fieldFormDefinition.put("validationMessage", validationMessage);
		}
		boolean readOnly = annotation.readOnly();
		if (readOnly) {
			fieldFormDefinition.put("readonly", readOnly);
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
