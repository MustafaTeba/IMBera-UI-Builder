package io.imbera.ui.core.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.executors.OnloadExecutorsEnum;

@Retention(RetentionPolicy.RUNTIME)
public @interface IMBeraFormDef {
	String title();
	OnloadExecutorsEnum[] onLoadExecutors();
	ActionsGroup[] ActionsGroups();
}