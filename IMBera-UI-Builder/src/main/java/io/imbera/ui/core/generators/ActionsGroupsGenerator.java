package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.ActionsGroup;

public class ActionsGroupsGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition, UIContainer form, Field field) {
		ActionsGroup annotation = field.getAnnotation(ActionsGroup.class);
		buildActionsFields(mapper,fieldFormDefinition, annotation.actions());
	}
	
	@Override
	public String getAnnotation() {
		return ActionsGroup.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return ActionsGroup.class.getSimpleName();
	}
}
