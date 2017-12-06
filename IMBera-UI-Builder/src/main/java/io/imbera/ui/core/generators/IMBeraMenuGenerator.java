package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.IMBeraFormDef;
import io.imbera.ui.core.form.IMBeraMenuDef;

public class IMBeraMenuGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode formDefinition,UIContainer form, Field field) {
		IMBeraMenuDef annotation = form.getClass().getAnnotation(IMBeraMenuDef.class);
		formDefinition.put("title", annotation.title());
		//
		Field[] declaredFields = form.getClass().getDeclaredFields();
		/**/
		ArrayNode fieldsDefinition = mapper.createArrayNode();
		Map<Field, JsonNode> nodes = initFieldsFormDefinition(mapper,form, declaredFields);
		Map<Field, JsonNode> sortedNodes = reorderFieldsBasedOnIndex(nodes);
		sortedNodes.entrySet().stream().forEach(nodesElement -> fieldsDefinition.add(nodesElement.getValue()));
		formDefinition.set("menus", fieldsDefinition);
	}
	
	@Override
	public String getAnnotation() {
		return IMBeraMenuDef.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return IMBeraMenuDef.class.getSimpleName();
	}
}
