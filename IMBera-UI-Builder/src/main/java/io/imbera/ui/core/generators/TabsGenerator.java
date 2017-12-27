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
import io.imbera.ui.core.form.Tabs;
import io.imbera.ui.core.form.TabsContainer;

public class TabsGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition , UIContainer form, Field field) {
		Tabs annotation = field.getAnnotation(Tabs.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		/**/
		Class< ? extends TabsContainer> tabsClass = (Class<? extends TabsContainer>) field.getType();
		Field[] tabsFields = tabsClass.getDeclaredFields();
		/**/
		UIContainer tabsObject = prepareUIConatinersField(form, field) ;
		/**/
		Map<Field, JsonNode> map = initFieldsFormDefinition(mapper, tabsObject , tabsFields);
		ArrayNode nodes = mapper.createArrayNode();
		map.entrySet().stream().forEach(nodesElement -> nodes.add(nodesElement.getValue()));
		fieldFormDefinition.set("tabs",nodes);
	}
	
	@Override
	public String getAnnotation() {
		return Tabs.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return Tabs.class.getSimpleName();
	}
}
