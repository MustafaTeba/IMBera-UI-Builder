package com.imbera.demo.executors;

public interface OnLoadExecutor {
	public Class<? extends AbstractOnloadExecutor> getExecutorClass();
}
