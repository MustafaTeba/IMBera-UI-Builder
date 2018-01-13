package io.imbera.ui.core.executors;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imbera.demo.screen.UIContainer;

import io.imbera.ui.dto.ExecutorDTO;
import io.imbera.ui.dto.FieldDTO;

@Service
public abstract class AbstractExecutor {

	public UIContainer form;
	public abstract void doBussiness();

	public void execute(ExecutorDTO executorDTO) {
		List<FieldDTO> updateFields = new ArrayList<>();
		try {
			form = (UIContainer) Class.forName(executorDTO.getClassName()).newInstance();
			// Step 1
			setFieldsValues(form, executorDTO.getFieldsToPost());
			// Step 2
			doBussiness();
			// Step 3
			getUpdatedFields(form, executorDTO.getFieldsToUpdate());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	void setFieldsValues(UIContainer container, List<FieldDTO> fieldsToPost) {
		for (FieldDTO field : fieldsToPost) {
			List<String> path = Arrays.asList(field.getName().split("\\."));
			Collections.reverse(path);
			setFieldValue(container,path,0,field.getValue());
		}
	}

	void setFieldValue(UIContainer container, List<String> path, int index ,String value) {
		Field declaredField = null;
		UIContainer newContainer = null;
		try {
			declaredField = container.getClass().getDeclaredField(path.get(index));
			boolean accessible = declaredField.isAccessible();
			if (path.size() - 1 == index) {
				declaredField.setAccessible(true);
				declaredField.set(container, valueConvertuer(declaredField, value));
				declaredField.setAccessible(accessible);
				return;
			}
			declaredField.setAccessible(true);
			if (declaredField.get(container) == null) {
				newContainer = (UIContainer) declaredField.getType().newInstance();
				declaredField.set(container, newContainer);
			}else{
				newContainer = (UIContainer) declaredField.get(container);
			}
			declaredField.setAccessible(accessible);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InstantiationException e) {
			e.printStackTrace();
		}
		setFieldValue(newContainer, path, ++index ,value);
	}
	
	Object getFieldValue(UIContainer container, List<String> path, int index) {
		Field declaredField = null;
		UIContainer newContainer = null;
		try {
			declaredField = container.getClass().getDeclaredField(path.get(index));
			boolean accessible = declaredField.isAccessible();
			if (path.size() - 1 == index) {
				declaredField.setAccessible(true);
				Object value = declaredField.get(container);
				declaredField.setAccessible(accessible);
				return value;
			}
			declaredField.setAccessible(true);
			if (declaredField.get(container) == null) {
				return null;
			}else{
				newContainer = (UIContainer) declaredField.get(container);
			}
			declaredField.setAccessible(accessible);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return getFieldValue(newContainer, path, ++index);
	}

	Object valueConvertuer(Field field, String value) {
		if (value != null && field.getType() == Integer.class)
			return Integer.parseInt(value);

		return value;
	}

	public List<FieldDTO> getUpdatedFields(UIContainer container, List<FieldDTO> fieldsToUpdate) {
		for (FieldDTO field : fieldsToUpdate) {
			List<String> path = Arrays.asList(field.getName().split("\\."));
			Collections.reverse(path);
			Object value = getFieldValue(container, path, 0);
			if(value != null)
				field.setValue(value.toString());
		}
		return fieldsToUpdate;
	}

}
