package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.TextArea;

public class TextAreaGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form,Field field) {
		TextArea annotation = field.getAnnotation(TextArea.class);
		
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldIMBeraExecutors(mapper,fieldFormDefinition, annotation.executor());
		buildFieldValue(fieldFormDefinition, form, field);
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
		String validationMessage = annotation.validationMessage();
		if (!validationMessage.isEmpty()) {
			fieldFormDefinition.put("validationMessage", validationMessage);
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
