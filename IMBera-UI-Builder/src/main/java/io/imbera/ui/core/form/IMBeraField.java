package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.imbera.demo.executors.enums.FieldsMap;

@Retention(RUNTIME)
@Target(TYPE)
public @interface IMBeraField {
	String title();
	String description() default "";
	int colSize() default 12;
	boolean readOnly() default false;
	boolean required() default false;
	/**/
	FieldsMap FieldsMap();
}
