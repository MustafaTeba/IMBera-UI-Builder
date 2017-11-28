package com.imbera.demo.executors;

public interface Executor {
	public Class<? extends AbstractExecutor> getExecutorClass();
}
