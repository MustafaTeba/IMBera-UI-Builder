package com.imbera.demo.executors;

import com.imbera.demo.enums.ExecutorType;
import com.imbera.demo.enums.FieldsMap;

public interface FieldExecutor extends Executor{
	public FieldsMap[] getFieldsToUpdate();
	public FieldsMap[] getFieldsToPost();
	public ExecutorType getExecutorType();
}
