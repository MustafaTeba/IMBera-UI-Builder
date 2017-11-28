package io.imbera.ui.core.form;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;

import io.imbera.ui.core.enums.ActionType;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Actions.class)
public @interface Action {
	
	ActionType type();

	String title();

	int colSize() default 12;

	String onClick_Functions() default "";

	ExecutorsEnum[] Executors();
}
