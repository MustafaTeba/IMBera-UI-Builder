package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.ComboBox;
import io.imbera.ui.core.form.ValuesContainer;
import io.imbera.ui.core.logging.IMBeraLogger;

public class ComboBoxGenerator extends FormDefinitionGenerator implements OptionField {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition,UIContainer form, Field field) {
		ComboBox annotation = field.getAnnotation(ComboBox.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldsExecutors(mapper,fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		buildOptionasValues(mapper, fieldFormDefinition, field, annotation.options());
		fieldFormDefinition.put("multiple", annotation.multiple());
	}

	@Override
	public String getAnnotation() {
		return ComboBox.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return ComboBox.class.getSimpleName();
	}
}
