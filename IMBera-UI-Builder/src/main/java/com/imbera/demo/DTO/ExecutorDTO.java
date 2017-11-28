package com.imbera.demo.DTO;

import java.util.List;

public class ExecutorDTO {

	private int id;
	private List<FieldDTO> fields;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<FieldDTO> getFields() {
		return fields;
	}
	public void setFields(List<FieldDTO> fields) {
		this.fields = fields;
	}
	
}
