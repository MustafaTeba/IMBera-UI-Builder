package com.imbera.demo.renderer;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.menu.MainMenu;
import com.imbera.demo.menu.UIMenu;
import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.core.schema.UiFormSchemaGenerator;
import io.imbera.ui.dto.UiForm;

@Service
public class UiDemoRenderer {
	public ObjectNode renderForm(UIContainer form) throws JsonMappingException {
		return UiFormSchemaGenerator.get().generateForm(form);
	}

	public ObjectNode renderMenu(UIMenu menu) throws JsonMappingException {
		return UiFormSchemaGenerator.get().generateMenu(menu);
	}
}
