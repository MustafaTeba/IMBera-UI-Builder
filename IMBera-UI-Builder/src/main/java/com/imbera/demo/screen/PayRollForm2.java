package com.imbera.demo.screen;

import java.io.Serializable;

import io.imbera.ui.core.enums.ActionType;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.IMBeraFormDef;

@IMBeraFormDef(title = "PayRoll", onLoadExecutors = {}, ActionsGroups = {
		@ActionsGroup(actions = { 
				@Action(title = "InitExextutor", type = ActionType.Button, Executors = {}),
				@Action(title = "PostExextutor", type = ActionType.Button, Executors = {}),
				@Action(title = "JS Executor", type = ActionType.Button, onClick_Functions = "ValidateForm", Executors = {}) 
				}) 
		}
)
public class PayRollForm2 implements Serializable, UIContainer {
	/*private final long serialVersionUID = -1933740572277496405L;
	---------0 : 99 -------------
	@Index(value = 0)
	@TextField(
			basicInfo = @IMBeraField(title = "employeeID", colSize = 3, postedExecutors = {}, updatedExecutors = {}),
			placeHolder = "Enter ID",
			Executors = {}
	)
	private Integer employeeID;

	public Integer getEmployeeID() {
		return emِAAAAployeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}*/
}
