package com.imbera.demo.executors.fieldsExecutors;

import com.imbera.demo.executors.AbstractExecutor;
import com.imbera.demo.screen.PayRollForm;

public class PostExextutor extends AbstractExecutor{
	PayRollForm payRollForm =null;

	@Override
	public void  doBussiness() {
		payRollForm = (PayRollForm) form;
		payRollForm.getPersonalPanel().setEmployeeID(1000);
		payRollForm.setEmployeeID(payRollForm.getEmployeeID()+100);
	}
}
