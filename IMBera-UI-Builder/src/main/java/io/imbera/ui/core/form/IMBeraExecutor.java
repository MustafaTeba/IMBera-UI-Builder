package io.imbera.ui.core.form;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import io.imbera.ui.core.executors.AbstractExecutor;

@Retention(RUNTIME)
@Target(TYPE)
public @interface IMBeraExecutor {
	Action[] actions();
	Class<? extends AbstractExecutor>[] updatedExecutors();
	Class<? extends AbstractExecutor>[] postedExecutors();
}
