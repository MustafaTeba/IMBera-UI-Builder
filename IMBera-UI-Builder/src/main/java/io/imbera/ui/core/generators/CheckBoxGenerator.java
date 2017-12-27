package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.CheckBox;

public class CheckBoxGenerator extends FormDefinitionGenerator {
	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form, Field field) {
		CheckBox annotation = field.getAnnotation(CheckBox.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldIMBeraExecutors(mapper, fieldFormDefinition, annotation.executor());
		buildFieldValue(fieldFormDefinition, form, field);
		buildOptionasValues(mapper, fieldFormDefinition, field, annotation.options());
		fieldFormDefinition.put("multiple", annotation.multiple());
	}

	@Override
	public String getAnnotation() {
		return CheckBox.class.getName();
	}

	@Override
	public String getAnnotationName() {
		return CheckBox.class.getSimpleName();
	}
}
