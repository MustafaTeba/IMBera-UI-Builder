package io.imbera.ui.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.imbera.ui.core.executors.AbstractExecutor;

public final class ExecutorsRegisterFactory {

	public Optional<Integer> getExecutorID(Class<? extends AbstractExecutor> executorClass) {
		return Optional.ofNullable(REGISTERS.indexOf(executorClass));
	}
	
	public Optional<Class<? extends AbstractExecutor>> getExecutorClass(Integer executorID) {
		return Optional.ofNullable(REGISTERS.get(executorID));
	}

	void register(Class<? extends AbstractExecutor> executor) {
		REGISTERS.add(executor);
	}

	public static ExecutorsRegisterFactory getInstance() {
		if (instance == null) {
			instance = new ExecutorsRegisterFactory();
		}
		return instance;
	}

	private static final List<Class<? extends AbstractExecutor>> REGISTERS = new ArrayList<Class<? extends AbstractExecutor>>();

	private static ExecutorsRegisterFactory instance;
	private ExecutorsRegisterFactory() {
	}
}
