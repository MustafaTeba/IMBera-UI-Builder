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
public @interface CheckBox {

	String title();

	int colSize() default 12;

	String[] values() default {};

	boolean multiple() default false;

	boolean required() default false;

	String defaultvalue() default "";

	Class<? extends ValuesContainer> titleMap() default ValuesContainer.class;

	FieldsMap FieldsMap();

	ExecutorsEnum[] Executors();
	
}
