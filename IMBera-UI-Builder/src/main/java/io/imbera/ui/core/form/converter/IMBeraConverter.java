package io.imbera.ui.core.form.converter;

import java.lang.reflect.Field;

public interface IMBeraConverter {
	String getAsString(Field field);
	Object getAsObject(Field field);
}
