package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.executors.enums.FieldsMap;

import io.imbera.ui.core.form.CheckBox;
import io.imbera.ui.core.form.IMBeraField;
import io.imbera.ui.core.form.IMBeraOptions;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.TabContainer;
import io.imbera.ui.core.form.TextField;

public class PersonalTab2  implements Serializable , TabContainer{

	private static final long serialVersionUID = -4515281198646980585L;
	
	@Index(value = 0)
	@TextField(placeHolder = "Enter ID", Executors = {}, basicInfo = @IMBeraField(FieldsMap = FieldsMap.PersonalTab2_employeeID, title = "employeeID"))
	private int employeeID;

	@Index(value = 1)
	@CheckBox(Executors = {}, basicInfo = @IMBeraField(FieldsMap = FieldsMap.PersonalTab2_checkBoxs, title = ""), options = @IMBeraOptions(values = {"111", "222", "333" }, valuesClass = GenderTitleMap.class))
	private String checkBoxs;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getCheckBoxs() {
		return checkBoxs;
	}

	public void setCheckBoxs(String checkBoxs) {
		this.checkBoxs = checkBoxs;
	}
	
	
}