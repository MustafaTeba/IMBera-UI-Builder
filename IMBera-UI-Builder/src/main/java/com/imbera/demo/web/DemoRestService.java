package com.imbera.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.imbera.demo.DTO.ExecutorDTO;
import com.imbera.demo.DTO.FieldDTO;
import com.imbera.demo.executors.AbstractExecutor;
import com.imbera.demo.executors.enums.ExecutorsEnum;
import com.imbera.demo.executors.enums.UIFormsEnum;
import com.imbera.demo.menu.MainMenu;
import com.imbera.demo.menu.UIMenu;
import com.imbera.demo.renderer.UiDemoRenderer;
import com.imbera.demo.screen.UIContainer;


/**
 * REST controller for managing Ui.
 */
@RestController
@RequestMapping("/api")
public class DemoRestService {

	@Autowired
	private final UiDemoRenderer renderer;
	
	public DemoRestService(UiDemoRenderer renderer) {
		this.renderer = renderer;
	}

	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	
	@CrossOrigin("http://localhost:8080")
	@RequestMapping("/ui")
	public ObjectNode renderUI(@RequestParam(value = "formID") Integer formID) throws JsonMappingException {
		try {
			UIContainer container = (UIContainer) UIFormsEnum.getEnumByID(formID).getClazz().newInstance();
			return renderer.renderForm(container);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@CrossOrigin("http://localhost:8080")
	@RequestMapping("/menu")
	public ObjectNode renderMenu() throws JsonMappingException {
		UIMenu menu;
		try {
			menu = MainMenu.class.newInstance();
			return renderer.renderMenu(menu);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@CrossOrigin("http://localhost:8080")
	@RequestMapping(value ="/processAction",method = RequestMethod.POST)
	public List<FieldDTO>  processAction(@RequestBody ExecutorDTO executorDTO){
		try {
			AbstractExecutor executor = ExecutorsEnum.getEnumByID(executorDTO.getId()).getExecutorClass().getConstructor().newInstance();
			return executor.execute(executorDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
