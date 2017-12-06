package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.imbera.demo.executors.enums.ExecutorsEnum;
import com.imbera.demo.executors.enums.FieldsMap;

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
	ExecutorsEnum[] Executors();
}
