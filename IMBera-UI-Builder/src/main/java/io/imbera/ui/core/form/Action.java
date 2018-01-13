package io.imbera.ui.core.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.imbera.ui.core.enums.ActionType;
import io.imbera.ui.core.executors.AbstractExecutor;

@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
	ActionType type();
	String onClick_Functions() default "";
	Class<? extends AbstractExecutor>[] Executors();
	String title() default "";
}