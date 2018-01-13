package io.imbera.ui.core.generators;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.ExecutorsRegisterFactory;
import io.imbera.ui.core.FormDefinitionGeneratorFactory;
import io.imbera.ui.core.executors.AbstractExecutor;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.IMBeraExecutor;
import io.imbera.ui.core.form.IMBeraField;
import io.imbera.ui.core.form.IMBeraOptions;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.ValuesContainer;
import io.imbera.ui.core.logging.IMBeraLogger;

public abstract class FormDefinitionGenerator {

	/**/
	//final static String KEY_IDENTIFER = "id";
	final static String KEY_VALUE = "value";
	final static String KEY_TITLE = "title";
	final static String KEY_NAME = "name";
	final static String KEY_TYPE = "type";
	final static String KEY_FIELDS = "fields";
	final static String KEY_OPTIONS = "options";

	/**/
	final static String KEY_ACTIONS_GROUPS = "actionsGroups";
	final static String KEY_ACTIONS = "actions";
	final static String KEY_EXECUTORS = "executors";
	final static String KEY_EXECUTOR = "executor";
	final static String KEY_EXECUTOR_TYPE = "executorType";
	final static String KEY_POST_AT = "postAt";
	final static String KEY_UPDATE_AT = "updatAt";
	final static String KEY_JS_ACTION = "jsAction";

	/**/
	final static String KEY_ON_CLICK = "onClick";
	final static String KEY_TABS = "tabs";
	final static String KEY_ITEMS = "items";
	final static String KEY_COLSIZE = "colSize";
	
	static Map<Class<? extends AbstractExecutor>,Integer> ActionMap = new HashMap<>();

	public abstract void generate(ObjectMapper mapper, ObjectNode fieldFormDefinition, UIContainer form, Field field);

	abstract public String getAnnotation();

	abstract String getAnnotationName();

	void buildBasicInfo(ObjectNode fieldFormDefinition, Field field, IMBeraField basicInfo) {
		//fieldFormDefinition.put(KEY_IDENTIFER, ++fieldId);
		fieldFormDefinition.put(KEY_TYPE, getAnnotationName());
		fieldFormDefinition.put(KEY_NAME, field.getName());
		fieldFormDefinition.put(KEY_TITLE, basicInfo.title());
		fieldFormDefinition.put(KEY_COLSIZE, basicInfo.colSize());
	}

	Map<Field, JsonNode> initFieldsFormDefinition(ObjectMapper mapper, UIContainer form, Field[] declaredFields) {
		Map<Field, JsonNode> nodes = new HashMap<>();
		Arrays.stream(declaredFields).forEach(field -> {
			buildFormDefinition(nodes, mapper, form, field);
		});
		return nodes;
	}

	void buildFormDefinition(Map<Field, JsonNode> nodes, ObjectMapper mapper, UIContainer form, Field field) {
		Arrays.stream(field.getAnnotations())
				.forEach(annotation -> buildFieldDefinition(form, field, annotation, mapper, nodes));
	}

	void buildFieldDefinition(UIContainer form, Field field, Annotation annotation, ObjectMapper mapper,
			Map<Field, JsonNode> nodes) {
		ObjectNode fieldFormDefinition = mapper.createObjectNode();
		FormDefinitionGeneratorFactory.getInstance().getGenerator(annotation.annotationType().getName())
				.ifPresent(generator -> {
					generator.generate(mapper, fieldFormDefinition, form, field);
					nodes.put(field, fieldFormDefinition);
				});
	}

	void buildFieldValue(ObjectNode fieldFormDefinition, UIContainer form, Field field) {
		if (form == null)
			return;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), form.getClass());
			Object objectValue = pd.getReadMethod().invoke(form);
			// TODO prepare field type
			if (field.getType().isAssignableFrom(Integer.class))
				fieldFormDefinition.put(KEY_VALUE, (Integer) objectValue);
			else if (field.getType().isAssignableFrom(String.class))
				fieldFormDefinition.put(KEY_VALUE, objectValue == null ? null : objectValue.toString());
		} catch (IllegalArgumentException | IllegalAccessException | IntrospectionException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	UIContainer prepareUIConatinersField(UIContainer form, Field field) {
		if (form == null)
			return null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), form.getClass());
			return (UIContainer) pd.getReadMethod().invoke(form);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	List<UIContainer> prepareTableRowsUIConatinersField(UIContainer form, Field field) {
		if (form == null)
			return null;
		try {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), form.getClass());
			return (List<UIContainer>) pd.getReadMethod().invoke(form);
		} catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	void buildActionsFields(ObjectMapper mapper, ObjectNode fieldFormDefinition, ActionsGroup[] actionsGroups) {
		ArrayNode actionsGroupsNode = mapper.createArrayNode();
		Arrays.stream(actionsGroups).forEach(actionGroup -> {
			ObjectNode actionGroupNode = mapper.createObjectNode();
			buildActionsFields(mapper, actionGroupNode, actionGroup.actions());
			actionsGroupsNode.add(actionGroupNode);
		});
		fieldFormDefinition.set(KEY_ACTIONS_GROUPS, actionsGroupsNode);
	}

	void buildActionsFields(ObjectMapper mapper, ObjectNode fieldNode, Action[] actions) {
		ArrayNode actionsNode = mapper.createArrayNode();
		Arrays.stream(actions).forEach(action -> {
			ObjectNode actionNode = mapper.createObjectNode();
			buildActionFields(mapper, actionNode, action);
			actionsNode.add(actionNode);
		});
		fieldNode.set(KEY_ACTIONS, actionsNode);
	}

	void buildActionFields(ObjectMapper mapper, ObjectNode actionNode, Action action) {
		actionNode.put(KEY_TYPE, action.type().toString());
		actionNode.put(KEY_TITLE, action.title());
		actionNode.put(KEY_JS_ACTION, action.onClick_Functions());
		buildFieldExecutors(mapper, actionNode, action.Executors());
	}

	void buildFieldIMBeraExecutors(ObjectMapper mapper, ObjectNode fieldNode, IMBeraExecutor imberaExecutor){
		fieldNode.set(KEY_POST_AT, getExecutorNodes(mapper, imberaExecutor.postedExecutors()));
		fieldNode.set(KEY_UPDATE_AT, getExecutorNodes(mapper, imberaExecutor.updatedExecutors()));
		buildActionsFields(mapper, fieldNode, imberaExecutor.actions());
	}
	void buildFieldExecutors(ObjectMapper mapper, ObjectNode actionNode, Class<? extends AbstractExecutor>[] executors) {
		actionNode.set(KEY_EXECUTORS, getExecutorNodes(mapper, executors));
	}
	
	ArrayNode getExecutorNodes(ObjectMapper mapper, Class<? extends AbstractExecutor>[] executors){
		ArrayNode executorsNode = mapper.createArrayNode();
		for (Class<? extends AbstractExecutor> executor : executors) {
			ExecutorsRegisterFactory.getInstance().getExecutorID(executor).ifPresent(executorID -> {
				ObjectNode executorNode = mapper.createObjectNode();
				executorNode.put(KEY_EXECUTOR, executorID);
				executorsNode.add(executorNode);
			});
		}
		return executorsNode;
	}

	Map<Field, JsonNode> reorderFieldsBasedOnIndex(Map<Field, JsonNode> nodes) {
		Comparator<? super Entry<Field, JsonNode>> tabIndexComparator = (entry1, entry2) -> {
			Index field1Index = entry1.getKey().getAnnotation(Index.class);
			Index field2Index = entry2.getKey().getAnnotation(Index.class);
			return Integer.compare((field1Index != null ? field1Index.value() : Integer.MAX_VALUE),
					field2Index != null ? field2Index.value() : Integer.MAX_VALUE);
		};
		return nodes.entrySet().stream().sorted(tabIndexComparator).collect(Collectors.toMap(Map.Entry::getKey,
				Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

	}

	void buildOptionasValues(ObjectMapper mapper, ObjectNode fieldFormDefinition, Field field, IMBeraOptions options) {
		ArrayNode optionsNode = mapper.createArrayNode();
		Arrays.stream(options.values()).forEach(value -> buildOption(mapper, optionsNode, value, value));
		if (!options.valuesClass().equals(ValuesContainer.class)) {
			try {
				(options.valuesClass()).newInstance().getValues().entrySet().stream()
						.forEach(mapEntry -> buildOption(mapper, optionsNode, mapEntry.getKey(), mapEntry.getValue()));
			} catch (InstantiationException | IllegalAccessException e) {
				IMBeraLogger.getLogger().error(e.getMessage());
				throw new RuntimeException(e);
			}
		}
		fieldFormDefinition.set(KEY_OPTIONS, optionsNode);
	}

	void buildOption(ObjectMapper checkBoxMapper, ArrayNode Options, String Key, String value) {
		ObjectNode entry = checkBoxMapper.createObjectNode();
		entry.put(KEY_NAME, Key);
		entry.put(KEY_VALUE, value);
		Options.add(entry);
	}
}
