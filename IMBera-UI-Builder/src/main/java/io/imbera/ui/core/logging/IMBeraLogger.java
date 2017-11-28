package io.imbera.ui.core.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class IMBeraLogger {

	private final static Logger LOGGER = LoggerFactory.getLogger("IMBeraLogger");

	public static Logger getLogger() {
		return LOGGER;
	}

	private IMBeraLogger() {
	}

}
