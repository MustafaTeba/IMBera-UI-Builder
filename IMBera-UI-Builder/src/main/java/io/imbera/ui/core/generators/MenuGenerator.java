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

import io.imbera.ui.core.form.Menu;

public class MenuGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition,UIContainer form, Field field) {
		Menu annotation = field.getAnnotation(Menu.class);
		fieldFormDefinition.put("menuType", annotation.menuType().toString());
		fieldFormDefinition.put("name", annotation.name());
		fieldFormDefinition.put("targetForm", annotation.targetForm().ordinal());
		Field[] subMenuFields =annotation.menuClass().getDeclaredFields();
		Map<Field, JsonNode> map = initFieldsFormDefinition(mapper,form, subMenuFields);
		ArrayNode subMenuNodes = mapper.createArrayNode();
		map.entrySet().stream().forEach(nodesElement -> subMenuNodes.add(nodesElement.getValue()));
		fieldFormDefinition.set("subMenus", subMenuNodes);
	}
	
	@Override
	public String getAnnotation() {
		return Menu.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return Menu.class.getSimpleName();
	}
}
