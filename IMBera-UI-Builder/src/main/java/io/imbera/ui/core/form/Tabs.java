package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Tabs {
	String title();
	int index();
	int colSize() default 12;
	//Tab[] tabs();
	Class<? extends TabsContainer> tabsClass();
}
