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

public class RadioBoxGenerator implements FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition,UIContainer form, Field field) {

		RadioBox annotation = field.getAnnotation(RadioBox.class);
		
		buildBasicInfo(fieldFormDefinition, field.getName(),getAnnotationName() , annotation.title(),annotation.colSize() ,annotation.FieldsMap().ordinal());
		buildFieldsExecutors(mapper,fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		
		fieldFormDefinition.put("readOnly", annotation.readOnly());
		JsonNode radioFieldFormDefinition = fieldFormDefinition;
		ObjectMapper radioMapper = new ObjectMapper();
		ArrayNode titlesMap = radioMapper.createArrayNode();

		Map<String, String> map;

		try {
			map = (annotation.titleMap()).newInstance().getValues();
			for (Map.Entry<String, String> iterator : map.entrySet()) {
				ObjectNode entry = radioMapper.createObjectNode();
				entry.put("name", iterator.getKey());
				entry.putPOJO("value", iterator.getValue());
				titlesMap.add(entry);
			}
		} catch (InstantiationException | IllegalAccessException e) {
			IMBeraLogger.getLogger().error(e.getMessage());
			throw new RuntimeException(e);
		}

		((ObjectNode) radioFieldFormDefinition).set("options", titlesMap);

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
