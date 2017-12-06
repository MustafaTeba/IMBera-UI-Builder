package io.imbera.ui.core.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.fasterxml.jackson.databind.JsonNode;
import com.imbera.demo.executors.enums.ExecutorsEnum;

import io.imbera.ui.core.enums.ActionType;

@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	//IMBeraField basicInfo();
	ActionType type();
	String onClick_Functions() default "";
	ExecutorsEnum[] Executors();
	
	String title();
	String description() default "";
	int colSize() default 12;
}