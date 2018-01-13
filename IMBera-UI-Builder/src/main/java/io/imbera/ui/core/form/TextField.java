package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.imbera.ui.core.executors.AbstractExecutor;
import io.imbera.ui.core.form.converter.IMBeraConverter;

@Retention(RUNTIME)
@Target(FIELD)
public @interface TextField {
	IMBeraField basicInfo();
	String placeHolder() default "";
	int minLenght() default 0;
	int maxLenght() default Integer.MAX_VALUE;
	String fieldAddonLeft() default "";
	String fieldAddonRight() default "";
	String pattern() default "";
	String validationMessage() default "";
	/**/
	IMBeraExecutor executor();
	//
	//Class<? extends IMBeraConverter>[] updatedExecutors();
	//Class<? extends AbstractExecutor>[] postedExecutors();
}
