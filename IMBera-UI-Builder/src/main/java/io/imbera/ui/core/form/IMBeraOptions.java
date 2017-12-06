package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface IMBeraOptions {
	String[] values() default {};
	Class<? extends ValuesContainer> valuesClass() default ValuesContainer.class;
}
