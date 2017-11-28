package com.imbera.demo.executors;

import org.springframework.stereotype.Service;

import com.imbera.demo.screen.UIContainer;

@Service
public abstract class AbstractOnloadExecutor {
	
	public UIContainer form;
	
	public AbstractOnloadExecutor setExecutorForm (UIContainer form) {
		this.form = form;
		return this;
	}
	
	public Integer getValueAsIntger(String value){
		return Integer.parseInt(value);
	}
	public abstract void doBussiness();
}
