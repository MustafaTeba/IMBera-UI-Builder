package io.imbera.ui.core.form;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Actions {
	
	Action[] value();

	int colSize() default 12;
}
