package com.imbera.demo.executors;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.imbera.demo.DTO.ExecutorDTO;
import com.imbera.demo.DTO.FieldDTO;
import com.imbera.demo.executors.enums.ExecutorsEnum;
import com.imbera.demo.executors.enums.FieldsMap;
import com.imbera.demo.screen.UIContainer;

@Service
public abstract class AbstractExecutor {

	public Map<Class<? extends UIContainer>, UIContainer> formsMap = new HashMap<>();
	public abstract void doBussiness();

	public List<FieldDTO> execute(ExecutorDTO executorDTO) {
		ExecutorsEnum executor = ExecutorsEnum.getEnumByID(executorDTO.getId());
		try {
			for (FieldsMap fieldMap : executor.getFieldsToUpdate()) {
				Class<? extends UIContainer> fieldClazz = fieldMap.getClazz();
				if (!formsMap.containsKey(fieldClazz))
					formsMap.put(fieldClazz, (UIContainer) fieldClazz.newInstance());
			}
			for (FieldDTO field : executorDTO.getFields()) {
				FieldsMap fieldMap = FieldsMap.getEnumByID(field.getId());
				Class<? extends UIContainer> fieldClazz = FieldsMap.getEnumByID(field.getId()).getClazz();
				if (!formsMap.containsKey(fieldClazz))
					formsMap.put(fieldClazz, (UIContainer) fieldClazz.newInstance());
				UIContainer UIForm = formsMap.get(fieldClazz);
				Field declaredField = UIForm.getClass().getDeclaredField(fieldMap.getField().getName());
				boolean accessible = declaredField.isAccessible();
				declaredField.setAccessible(true);
				declaredField.set(UIForm, valueConvertuer(declaredField, field.getValue()));
				declaredField.setAccessible(accessible);
			}
		} catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		doBussiness();
		return getUpdatedFields(executor.getFieldsToUpdate());
	}

	Object valueConvertuer(Field field, String value) {
		if (value != null && field.getType() == Integer.class)
			return Integer.parseInt(value);

		return value;
	}

	public List<FieldDTO> getUpdatedFields(FieldsMap[] fields) {
		List<FieldDTO> fieldsDTO = new ArrayList<>();
		try {
			for (FieldsMap fieldMap : fields) {
				Class<? extends UIContainer> fieldClazz = fieldMap.getClazz();
				UIContainer UIForm = formsMap.get(fieldClazz);
				Field declaredField = UIForm.getClass().getDeclaredField(fieldMap.getField().getName());
				//
				FieldDTO fieldDTO = new FieldDTO(fieldMap.ordinal(),fieldMap.toString());
				//
				boolean accessible = declaredField.isAccessible();
				declaredField.setAccessible(true);
				Integer value = (Integer) declaredField.get(UIForm) ;
				declaredField.setAccessible(accessible);				
				fieldDTO.setValue(value+"");
				//
				fieldsDTO.add(fieldDTO);
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fieldsDTO;
	}

}
