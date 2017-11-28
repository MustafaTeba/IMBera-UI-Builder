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
public @interface RadioBox {

	/* the title of the RadioBox */
	String title();

	int colSize() default 12;

	boolean readOnly() default false;

	Class<? extends ValuesContainer> titleMap();
	
	FieldsMap FieldsMap();

	ExecutorsEnum[] Executors();

}
