package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.imbera.demo.executors.enums.ExecutorsEnum;
import com.imbera.demo.executors.enums.FieldsMap;

@Retention(RUNTIME)
@Target(FIELD)
public @interface RadioBox {
	IMBeraField basicInfo();
	IMBeraOptions options();
	FieldsMap FieldsMap();
	ExecutorsEnum[] Executors();
}
