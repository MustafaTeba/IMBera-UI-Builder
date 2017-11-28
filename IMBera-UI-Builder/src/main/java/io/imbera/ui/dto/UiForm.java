package io.imbera.ui.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class UiForm implements Serializable {

	private transient ObjectNode form;

	public UiForm(ObjectNode form) {
		setForm(form);
	}
	
	public ObjectNode getForm() {
		return form;
	}

	public void setForm(ObjectNode form) {
		this.form = form;
	}

	private static final long serialVersionUID = -2534915468830780L;
}
