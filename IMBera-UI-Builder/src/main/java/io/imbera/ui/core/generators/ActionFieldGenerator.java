package io.imbera.ui.core.generators;

import java.lang.reflect.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.TextField;

public class ActionFieldGenerator extends FormDefinitionGenerator {

	@Override
	public void generate(ObjectMapper mapper,ObjectNode fieldFormDefinition, UIContainer form , Field field) {
		Action annotation = field.getAnnotation(Action.class);
		buildActionFields(mapper,fieldFormDefinition, annotation);
	}
	
	@Override
	public String getAnnotation() {
		return Action.class.getName();
	}
	
	@Override
	public String getAnnotationName() {
		return Action.class.getSimpleName();
	}
}
