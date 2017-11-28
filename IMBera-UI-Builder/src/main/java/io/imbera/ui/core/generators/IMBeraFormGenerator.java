package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.IMBeraFormDef;

public class IMBeraFormGenerator implements FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode formDefinition,UIContainer form, Field field) {
		IMBeraFormDef annotation = form.getClass().getAnnotation(IMBeraFormDef.class);
		Field[] declaredFields = form.getClass().getDeclaredFields();
		
		formDefinition.put("title", annotation.title());
		buildActionsFields(mapper, formDefinition, annotation.ActionsGroups());
		
		/**/
		ArrayNode fieldsDefinition = mapper.createArrayNode();
		Map<Field, JsonNode> nodes = initFieldsFormDefinition(mapper,form, declaredFields);
		Map<Field, JsonNode> sortedNodes = reorderFieldsBasedOnIndex(nodes);
		sortedNodes.entrySet().stream().forEach(nodesElement -> fieldsDefinition.add(nodesElement.getValue()));
		formDefinition.set("fields", fieldsDefinition);
	}
	
	@Override
	public String getAnnotation() {
		return IMBeraFormDef.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return IMBeraFormDef.class.getSimpleName();
	}
}
