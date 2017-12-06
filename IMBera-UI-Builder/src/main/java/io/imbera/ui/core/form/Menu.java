package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.imbera.demo.executors.enums.UIFormsEnum;

import io.imbera.ui.core.enums.MenuType;

@Retention(RUNTIME)
@Target(FIELD)
public @interface Menu {
	String name();
	UIFormsEnum targetForm();
	MenuType menuType();
	Class<? extends MenuContainer> menuClass() default MenuContainer.class;
}
