package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Tab;
import io.imbera.ui.core.form.Tabs;

public class TabGenerator implements FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition,UIContainer form, Field field) {
		Tab annotation = field.getAnnotation(Tab.class);
		buildBasicInfo(fieldFormDefinition, field.getName(),getAnnotationName() , annotation.title(),12);
		Field[] panelFields = annotation.tabClass().getDeclaredFields();
		UIContainer tabObject = prepareUIConatinersField(form, field) ;
		Map<Field, JsonNode> map = initFieldsFormDefinition(mapper, tabObject , panelFields);
		ArrayNode tabNodes = mapper.createArrayNode();
		map.entrySet().stream().forEach(nodesElement -> tabNodes.add(nodesElement.getValue()));
		fieldFormDefinition.put("title", annotation.title());
		fieldFormDefinition.set("fields", tabNodes);
	}
	
	@Override
	public String getAnnotation() {
		return Tab.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return Tab.class.getSimpleName();
	}
}
