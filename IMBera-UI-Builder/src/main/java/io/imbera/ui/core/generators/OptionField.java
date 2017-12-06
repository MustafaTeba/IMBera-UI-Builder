package io.imbera.ui.core.generators;

public interface OptionField {

	default String[] getValues() {
		return null;
	}

	default String[] getValuesClass() {
		return null;
	}

}
