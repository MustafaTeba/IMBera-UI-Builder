package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.RadioBox;
import io.imbera.ui.core.logging.IMBeraLogger;

public class RadioBoxGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form, Field field) {
		RadioBox annotation = field.getAnnotation(RadioBox.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		buildFieldsExecutors(mapper, fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		buildOptionasValues(mapper, fieldFormDefinition, field, annotation.options());
	}

	@Override
	public String getAnnotation() {
		return RadioBox.class.getName();
	}

	@Override
	public String getAnnotationName() {
		return RadioBox.class.getSimpleName();
	}
}
