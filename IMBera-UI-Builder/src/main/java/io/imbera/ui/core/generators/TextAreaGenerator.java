package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.TextArea;

public class TextAreaGenerator implements FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form,Field field) {
		TextArea annotation = field.getAnnotation(TextArea.class);
		
		buildBasicInfo(fieldFormDefinition, field.getName(),getAnnotationName() , annotation.title(),annotation.colSize() ,annotation.FieldsMap().ordinal());
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
		
		String description = annotation.description();
		if (!description.isEmpty()) {
			fieldFormDefinition.put("description", description);
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
		return TextArea.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return TextArea.class.getSimpleName();
	}
}
