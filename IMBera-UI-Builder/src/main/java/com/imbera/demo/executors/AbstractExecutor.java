package com.imbera.demo.executors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.imbera.demo.DTO.ExecutorDTO;
import com.imbera.demo.DTO.FieldDTO;
import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;

@Service
public abstract class AbstractExecutor {
	
	public ExecutorsEnum executor;
	public Map<FieldsMap,FieldDTO> fieldsToUpdateMap = new HashMap<FieldsMap,FieldDTO>();
	public Map<FieldsMap,FieldDTO> postedFieldsMap = new HashMap<FieldsMap,FieldDTO>();
	
	public AbstractExecutor setExecutorDTO (ExecutorDTO executorDTO) {
		executor = ExecutorsEnum.getEnumByID(executorDTO.getId());
		for (FieldDTO field : executorDTO.getFields())
			postedFieldsMap.put(FieldsMap.getEnumByID(field.getId()),field);
		for (FieldsMap fieldMap : executor.getFieldsToUpdate())
			fieldsToUpdateMap.put(fieldMap,new FieldDTO(fieldMap.ordinal(),fieldMap.toString()));
		return this;
	}
	
	public Integer getValueAsIntger(String value){
		return Integer.parseInt(value);
	}
	public abstract List<FieldDTO> doBussiness();
}
