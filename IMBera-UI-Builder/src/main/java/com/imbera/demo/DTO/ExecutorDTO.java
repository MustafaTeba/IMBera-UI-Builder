package com.imbera.demo.DTO;

import java.util.List;

public class ExecutorDTO {
	private Integer executor;
	private String className;
	private List<FieldDTO> fieldsToPost;
	private List<FieldDTO> fieldsToUpdate;
	
	public Integer getExecutor() {
		return executor;
	}
	public void setExecutor(Integer executor) {
		this.executor = executor;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<FieldDTO> getFieldsToPost() {
		return fieldsToPost;
	}
	public void setFieldsToPost(List<FieldDTO> fieldsToPost) {
		this.fieldsToPost = fieldsToPost;
	}
	public List<FieldDTO> getFieldsToUpdate() {
		return fieldsToUpdate;
	}
	public void setFieldsToUpdate(List<FieldDTO> fieldsToUpdate) {
		this.fieldsToUpdate = fieldsToUpdate;
	}
}
