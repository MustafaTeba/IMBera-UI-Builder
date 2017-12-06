package io.imbera.ui.core.generators;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Table;

public class TableGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition, UIContainer form,Field field) {
		Table annotation = field.getAnnotation(Table.class);
		buildBasicInfo(fieldFormDefinition, field, annotation.basicInfo());
		// set Table Fields
		Field[] panelFields = annotation.rowClass().getDeclaredFields();
		Map<Field, JsonNode> map = initFieldsFormDefinition(mapper, null , panelFields);
		ArrayNode nodes = mapper.createArrayNode();
		map.entrySet().stream().forEach(nodesElement -> nodes.add(nodesElement.getValue()));
		fieldFormDefinition.set("fields",nodes);
		// set Table Rows
		ArrayNode rowsNode = mapper.createArrayNode();
		List<UIContainer> tableRows = prepareTableRowsUIConatinersField(form, field) ;
		if(tableRows != null)
			tableRows.forEach(row ->{
				Map<Field, JsonNode> rowMap = initFieldsFormDefinition(mapper, row , panelFields);
				ArrayNode rowFields = mapper.createArrayNode();
				rowMap.entrySet().stream().forEach(nodesElement -> rowFields.add(nodesElement.getValue()));
				rowsNode.add(rowFields);
			});
		fieldFormDefinition.set("rows",rowsNode);
	}
	
	@Override
	public String getAnnotation() {
		return Table.class.getName();
	}
	@Override
	public String getAnnotationName() {
		return Table.class.getSimpleName();
	}
}
