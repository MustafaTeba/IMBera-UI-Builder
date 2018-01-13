package com.imbera.demo.fieldsExecutors;

import com.imbera.demo.screen.PayRollForm;

import io.imbera.ui.core.executors.AbstractExecutor;

public class PostExextutor extends AbstractExecutor{
	PayRollForm payRollForm =null;

	@Override
	public void  doBussiness() {
		payRollForm = (PayRollForm) form;
		payRollForm.getPersonalPanel().setEmployeeID(1000);
		payRollForm.setEmployeeID(payRollForm.getEmployeeID()+100);
	}
}
