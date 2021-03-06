package io.imbera.ui.core.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.imbera.ui.core.executors.AbstractOnloadExecutor;

@Retention(RetentionPolicy.RUNTIME)
public @interface IMBeraFormDef {
	String title();
	Class<? extends AbstractOnloadExecutor>[] onLoadExecutors();
	ActionsGroup[] ActionsGroups();
}
