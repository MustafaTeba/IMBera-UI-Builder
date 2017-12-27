package io.imbera.ui.core.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.imbera.demo.executors.AbstractExecutor;

import io.imbera.ui.core.enums.ActionType;

@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	ActionType type();
	String onClick_Functions() default "";
	Class<? extends AbstractExecutor>[] Executors();
	String title() default "";
}