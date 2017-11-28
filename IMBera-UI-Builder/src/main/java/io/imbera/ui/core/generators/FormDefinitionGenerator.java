package io.imbera.ui.core.generators;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.FormDefinitionGeneratorFactory;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.Index;

public interface FormDefinitionGenerator {

	String KEY_FIELDSET = "fieldset";
	String KEY_ON_CLICK = "onClick";
	String KEY_ACTIONS = "Actions";
	String KEY_TABS = "tabs";
	String KEY_TITLE = "title";
	String KEY_TYPE = "type";
	String KEY_ITEMS = "items";

	void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form, Field field);

	String getAnnotation();

	String getAnnotationName();

	default void buildBasicInfo(ObjectNode fieldFormDefinition, String fieldName, String type, String title,int colSize) {
		fieldFormDefinition.put("type", type);
		fieldFormDefinition.put("name", fieldName);
		fieldFormDefinition.put("title", title);
		fieldFormDefinition.put("colSize", colSize);
	}

	default Map<Field, JsonNode> initFieldsFormDefinition(ObjectMapper mapper, UIContainer form, Field[] declaredFields) {
		Map<Field, JsonNode> nodes = new HashMap<>();
		Arrays.stream(declaredFields).forEach(field -> {
			/**/
			buildFormDefinition(nodes, mapper, form, field);
		});
		return nodes;
	}

	default void buildFormDefinition(Map<Field, JsonNode> nodes, ObjectMapper mapper, UIContainer form, Field field) {
		Arrays.stream(field.getAnnotations())
				.forEach(annotation -> buildFieldDefinition(form, field, annotation, mapper, nodes));
	}

	default void buildFieldDefinition(UIContainer form, Field field, Annotation annotation, ObjectMapper mapper,
			Map<Field, JsonNode> nodes) {
		ObjectNode fieldFormDefinition = mapper.createObjectNode();
		FormDefinitionGeneratorFactory.getInstance().getGenerator(annotation.annotationType().getName())
				.ifPresent(generator -> {
					generator.generate(mapper, fieldFormDefinition, form, field);
					nodes.put(field, fieldFormDefinition);
				});
	}

	default void buildBasicInfo(ObjectNode fieldFormDefinition, String fieldName, String type, String title, int colSize, int id) {
		fieldFormDefinition.put("id", id);
		buildBasicInfo(fieldFormDefinition, fieldName, type, title, colSize);
	}
	
	default void buildFieldValue(ObjectNode fieldFormDefinition, UIContainer form, Field field) {
		if(form == null)
			return;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(),form.getClass());
			Object objectValue = pd.getReadMethod().invoke(form);
			if (field.getType().isAssignableFrom(Integer.TYPE))
				fieldFormDefinition.put("value", (Integer)objectValue);
			else if (field.getType().isAssignableFrom(String.class))
				fieldFormDefinition.put("value", objectValue == null ? null: objectValue.toString());
		} catch (IllegalArgumentException | IllegalAccessException | IntrospectionException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	default UIContainer prepareUIConatinersField(UIContainer form, Field field){
		if(form == null)
			return null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(),form.getClass());
			return (UIContainer) pd.getReadMethod().invoke(form);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	default List<UIContainer> prepareTableRowsUIConatinersField(UIContainer form, Field field){
		if(form == null)
			return null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(),form.getClass());
			return (List<UIContainer>) pd.getReadMethod().invoke(form);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	default void buildActionsFields(ObjectMapper mapper, ObjectNode fieldFormDefinition, ActionsGroup[] actionsGroups) {
		ArrayNode actionsGroupsNode = mapper.createArrayNode();
		Arrays.stream(actionsGroups).forEach(actionGroup -> {
			ObjectNode actionGroupNode = mapper.createObjectNode();
			buildActionsFields(mapper, actionGroupNode, actionGroup.actions());
			actionsGroupsNode.add(actionGroupNode);
		});
		fieldFormDefinition.set("actionsGroups", actionsGroupsNode);
	}

	default void buildActionsFields(ObjectMapper mapper, ObjectNode fieldFormDefinition, Action[] actions) {
		ArrayNode actionsNode = mapper.createArrayNode();
		Arrays.stream(actions).forEach(action -> {
			ObjectNode actionNode = mapper.createObjectNode();
			buildActionFields(mapper, actionNode, action);
			actionsNode.add(actionNode);
		});
		fieldFormDefinition.set("actions", actionsNode);
	}

	default void buildActionFields(ObjectMapper mapper, ObjectNode actionNode, Action action) {
		actionNode.put("type", action.type().toString());
		actionNode.put("title", action.title());
		actionNode.put("colSize", action.colSize());
		buildFieldsExecutors(mapper, actionNode, action.Executors());
	}

	default void buildFieldsExecutors(ObjectMapper mapper, ObjectNode actionNode, ExecutorsEnum[] Executors) {
		ArrayNode executorsNode = mapper.createArrayNode();
		for (ExecutorsEnum executor : Executors) {
			ObjectNode executorNode = mapper.createObjectNode();
			executorNode.put("id", executor.ordinal());
			executorNode.put("executorType", executor.getExecutorType().toString());
			ArrayNode fieldsNode = mapper.createArrayNode();
			for (FieldsMap fieldMap : executor.getFieldsToPost()) {
				ObjectNode fieldNode = mapper.createObjectNode();
				fieldNode.put("id", fieldMap.ordinal());
				fieldNode.put("name", fieldMap.toString());
				fieldsNode.add(fieldNode);
			}
			executorNode.set("fieldsToPost", fieldsNode);
			executorsNode.add(executorNode);
		}
		actionNode.set("executors", executorsNode);
	}
	
	default Map<Field, JsonNode> reorderFieldsBasedOnIndex(Map<Field, JsonNode> nodes) {
		Comparator<? super Entry<Field, JsonNode>> tabIndexComparator = (entry1, entry2) -> {
			Index field1Index = entry1.getKey().getAnnotation(Index.class);
			Index field2Index = entry2.getKey().getAnnotation(Index.class);
			return Integer.compare((field1Index != null ? field1Index.value() : Integer.MAX_VALUE),
					field2Index != null ? field2Index.value() : Integer.MAX_VALUE);
		};
		return nodes.entrySet().stream().sorted(tabIndexComparator).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	}
}
