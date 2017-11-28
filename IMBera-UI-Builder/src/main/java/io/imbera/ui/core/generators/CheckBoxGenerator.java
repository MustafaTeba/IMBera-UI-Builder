package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.CheckBox;
import io.imbera.ui.core.form.ValuesContainer;
import io.imbera.ui.core.logging.IMBeraLogger;

public class CheckBoxGenerator implements FormDefinitionGenerator{

	@Override
	public void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form, Field field) {
		CheckBox annotation = field.getAnnotation(CheckBox.class);
		
		buildBasicInfo(fieldFormDefinition, field.getName(), getAnnotationName() , annotation.title() , annotation.colSize() , annotation.FieldsMap().ordinal());
		buildFieldsExecutors(mapper,fieldFormDefinition, annotation.Executors());
		buildFieldValue(fieldFormDefinition, form, field);
		
		fieldFormDefinition.put("multiple", annotation.multiple());
		fieldFormDefinition.put("required", annotation.required());
		ArrayNode titlesMap = mapper.createArrayNode();
		if (annotation.values().length > 0) {
			Arrays.stream(annotation.values()).forEach(value -> buildValueDefinition(mapper, titlesMap, value));
			fieldFormDefinition.set("options", titlesMap);
		} else if (!annotation.titleMap().equals(ValuesContainer.class)) {
			try {
				Map<String, String> map = (annotation.titleMap()).newInstance().getValues();
				map.entrySet().stream().forEach(mapEntry -> {
					ObjectNode entryNode = mapper.createObjectNode();
					entryNode.put("name", mapEntry.getKey());
					entryNode.putPOJO("value", mapEntry.getValue());
					titlesMap.add(entryNode);
				});
				fieldFormDefinition.set("options", titlesMap);
			} catch (InstantiationException | IllegalAccessException e) {
				IMBeraLogger.getLogger().error(e.getMessage());
				throw new RuntimeException(e);
			}
		}
	}

	private void buildValueDefinition(ObjectMapper checkBoxMapper, ArrayNode titlesMap, String value) {
		ObjectNode entry = checkBoxMapper.createObjectNode();
		String upperCasedValue = value.toUpperCase();
		String lowerCasedValue = value.toLowerCase();
		if (value.equals(upperCasedValue)) {
			entry.put("name", value.toLowerCase());
		} else if (value.equals(lowerCasedValue)) {
			entry.put("name", value.replace(value.substring(0, 1), value.substring(0, 1).toUpperCase()));
		} else {
			entry.put("name", value);
		}
		entry.put("value", value);
		titlesMap.add(entry);
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
