package com.imbera.demo.executors.fields;

import java.util.List;

import com.imbera.demo.DTO.FieldDTO;
import com.imbera.demo.executors.AbstractExecutor;

public class SearchByIDExextutor extends AbstractExecutor{

	@Override
	public List<FieldDTO>  doBussiness() {
		/*studentRepository = (StudentRepository)repo;
		FieldDTO _id = postedFieldsMap.get(FieldsMap.id);
		Student student = studentRepository.findStudentById(getValueAsIntger(_id.getValue()));
		
		if(student !=null)
			fieldsToUpdateMap.get(FieldsMap.fullName).setValue(student.getName());
		*/
		//return new ArrayList<FieldDTO>(fieldsToUpdateMap.values());
		return null;
	}

}
