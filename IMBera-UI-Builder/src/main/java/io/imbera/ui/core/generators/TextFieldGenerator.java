package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.TextField;

public class TextFieldGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition, UIContainer form , Field field) {
		TextField annotation = field.getAnnotation(TextField.class);
		
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldsExecutors(mapper,fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		
		if (!annotation.pattern().isEmpty())
			fieldFormDefinition.put("pattern", annotation.pattern());

		if (annotation.minLenght() != 0)
			fieldFormDefinition.put("minLenght", annotation.minLenght());
		
		if (annotation.maxLenght() != Integer.MAX_VALUE)
			fieldFormDefinition.put("maxLenght", annotation.maxLenght());

		if (!annotation.fieldAddonLeft().isEmpty())
			fieldFormDefinition.put("fieldAddonLeft", annotation.fieldAddonLeft());

		if (!annotation.fieldAddonRight().isEmpty())
			fieldFormDefinition.put("fieldAddonRight", annotation.fieldAddonRight());

		if (!annotation.placeHolder().isEmpty())
			fieldFormDefinition.put("placeHolder", annotation.placeHolder());

		if (!annotation.validationMessage().isEmpty())
			fieldFormDefinition.put("validationMessage", annotation.validationMessage());

	}
	
	@Override
	public String getAnnotation() {
		return TextField.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return TextField.class.getSimpleName();
	}
}
