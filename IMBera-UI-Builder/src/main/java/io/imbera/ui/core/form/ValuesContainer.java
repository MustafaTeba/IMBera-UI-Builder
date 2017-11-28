package io.imbera.ui.core.form;

import java.util.HashMap;
import java.util.Map;

public interface ValuesContainer {

	default Map<String, String> getValues() {
		return new HashMap<>();
	}
}
