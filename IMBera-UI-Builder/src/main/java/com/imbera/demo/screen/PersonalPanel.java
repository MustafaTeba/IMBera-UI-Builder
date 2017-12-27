package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.executors.fieldsExecutors.PostExextutor;

import io.imbera.ui.core.enums.ActionType;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.CheckBox;
import io.imbera.ui.core.form.IMBeraExecutor;
import io.imbera.ui.core.form.IMBeraField;
import io.imbera.ui.core.form.IMBeraOptions;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.PanelContainer;
import io.imbera.ui.core.form.TextField;

public class PersonalPanel  implements Serializable , PanelContainer{

	private static final long serialVersionUID = -4515281198646980585L;

	@Index(value = 0)
	@TextField(
			basicInfo = @IMBeraField(title = "employeeID", colSize = 3),
			placeHolder = "Enter ID", 
			executor = @IMBeraExecutor(actions = {@Action(Executors = {PostExextutor.class}, type = ActionType.OnSelect)},
					postedExecutors = {PostExextutor.class},
					updatedExecutors = {PostExextutor.class}
					)
	)
	private Integer employeeID;
	
	@Index(value = 1)
	@CheckBox(
			basicInfo = @IMBeraField(title = "checkBoxs" , colSize = 3),
			options = @IMBeraOptions(values = {"111", "222", "333" }, valuesClass = GenderTitleMap.class),
			executor = @IMBeraExecutor(actions = {@Action(Executors = {PostExextutor.class}, type = ActionType.OnSelect)},
					postedExecutors = {PostExextutor.class},
					updatedExecutors = {PostExextutor.class}
					)
			
	)
	private String checkBoxs;

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getCheckBoxs() {
		return checkBoxs;
	}

	public void setCheckBoxs(String checkBoxs) {
		this.checkBoxs = checkBoxs;
	}
	
}