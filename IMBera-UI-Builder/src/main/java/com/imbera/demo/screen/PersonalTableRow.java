package com.imbera.demo.screen;

import java.io.Serializable;

import io.imbera.ui.core.form.TableRowContainer;

public class PersonalTableRow  implements Serializable , TableRowContainer{

	private static final long serialVersionUID = -4515281198646980585L;

	/*@Index(value = 0)
	@TextField(placeHolder = "Enter ID", Executors = {}, basicInfo = @IMBeraField(FieldsMap = FieldsMap.PersonalTableRow_employeeID, title = "employeeID"))
	private int employeeID;

	@Index(value = 1)
	@CheckBox(Executors = {}, 
	basicInfo = @IMBeraField(FieldsMap = FieldsMap.PersonalTableRow_checkBoxs, title = ""), 
	options = @IMBeraOptions(values = {"111", "222", "333" }, valuesClass = GenderTitleMap.class))
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
	}*/
	
}