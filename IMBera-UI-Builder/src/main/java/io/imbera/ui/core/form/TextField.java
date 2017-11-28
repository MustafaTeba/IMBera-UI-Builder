package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;
import com.imbera.demo.executors.*;

@Retention(RUNTIME)
@Target(FIELD)
public @interface TextField {
	String title();

	String placeHolder() default "";

	String description() default "";

	int colSize() default 12;

	int minLenght() default 0;

	int maxLenght() default Integer.MAX_VALUE;

	String fieldAddonLeft() default "";

	String fieldAddonRight() default "";

	String pattern() default "";

	boolean noTitle() default false;

	String validationMessage() default "";

	boolean readOnly() default false;

	FieldsMap FieldsMap();

	ExecutorsEnum[] Executors();
}
