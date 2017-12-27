package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface TextArea {
	IMBeraField basicInfo();
	String placeHolder() default "";
	int minLenght() default 0;
	int maxLenght() default Integer.MAX_VALUE;
	String fieldAddonLeft() default "";
	String fieldAddonRight() default "";
	String validationMessage() default "";
	/**/
	IMBeraExecutor executor();
}