package com.imbera.demo.executors.fields;

import java.util.ArrayList;
import java.util.List;

import com.imbera.demo.DTO.FieldDTO;
import com.imbera.demo.enums.FieldsMap;
import com.imbera.demo.executors.AbstractExecutor;

public class PostExextutor extends AbstractExecutor{


	@Override
	public List<FieldDTO>  doBussiness() {
		FieldDTO _fullName = postedFieldsMap.get(FieldsMap.fullNameTab1);
		FieldDTO fullName = fieldsToUpdateMap.get(FieldsMap.fullNameTab2);
		fullName.setValue(_fullName.getValue()+"$$$$");
		return new ArrayList<FieldDTO>(fieldsToUpdateMap.values());
	}
}
