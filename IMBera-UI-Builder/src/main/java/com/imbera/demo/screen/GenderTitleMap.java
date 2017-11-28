package com.imbera.demo.screen;

import java.util.HashMap;
import java.util.Map;

import io.imbera.ui.core.form.ValuesContainer;

public class GenderTitleMap implements ValuesContainer {

	@Override
	public Map<String, String> getValues() {
		HashMap<String, String> values = new HashMap<>();
		values.put("Male", "male");
		values.put("Female", "female");
		return values;
	}

}
