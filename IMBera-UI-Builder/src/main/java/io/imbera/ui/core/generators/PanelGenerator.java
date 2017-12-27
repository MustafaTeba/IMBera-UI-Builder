package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Panel;
import io.imbera.ui.core.form.PanelContainer;

public class PanelGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition , UIContainer form, Field field) {
		Panel annotation = field.getAnnotation(Panel.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		Class< ? extends PanelContainer> panelClass = (Class<? extends PanelContainer>) field.getType();
		Field[] panelFields = panelClass.getDeclaredFields();
		/**/
		UIContainer panelObject = prepareUIConatinersField(form, field) ;
		/**/
		Map<Field, JsonNode> map = initFieldsFormDefinition(mapper, panelObject , panelFields);
		ArrayNode nodes = mapper.createArrayNode();
		map.entrySet().stream().forEach(nodesElement -> nodes.add(nodesElement.getValue()));
		fieldFormDefinition.set("fields",nodes);
	}
	
	@Override
	public String getAnnotation() {
		return Panel.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return Panel.class.getSimpleName();
	}
}
