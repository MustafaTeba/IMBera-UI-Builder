package com.imbera.demo.executors.fieldsExecutors;

import com.imbera.demo.executors.AbstractExecutor;
import com.imbera.demo.screen.PayRollForm;

public class PostExextutor extends AbstractExecutor{
	PayRollForm payRollForm =null;

	@Override
	public void  doBussiness() {
		payRollForm = (PayRollForm) formsMap.get(PayRollForm.class);
		payRollForm.setEmployeeID(payRollForm.getEmployeeID()+100);
	}
}
