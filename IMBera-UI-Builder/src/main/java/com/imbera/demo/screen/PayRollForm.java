package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.fieldsExecutors.PostExextutor;

import io.imbera.ui.core.enums.ActionType;
import io.imbera.ui.core.executors.formsOnLoad.InitExecutor;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.CheckBox;
import io.imbera.ui.core.form.IMBeraExecutor;
import io.imbera.ui.core.form.IMBeraField;
import io.imbera.ui.core.form.IMBeraFormDef;
import io.imbera.ui.core.form.IMBeraOptions;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.Panel;
import io.imbera.ui.core.form.TextField;

@IMBeraFormDef(title = "PayRoll", onLoadExecutors = { InitExecutor.class }, 
ActionsGroups = {
		@ActionsGroup(actions = { 
				@Action(title = "InitExextutor", type = ActionType.Button, Executors = {}),
				@Action(title = "PostExextutor", type = ActionType.Button, Executors = {PostExextutor.class}),
				@Action(title = "JS Executor", type = ActionType.Button, onClick_Functions = "ValidateForm", Executors = {}) 
				}) 
		}
)
public class PayRollForm implements Serializable, UIContainer {
	private final long serialVersionUID = -1933740572277496405L;
	/*---------0 : 99 -------------*/
	@Index(value = 0)
	@TextField(
			basicInfo = @IMBeraField(title = "employeeID", colSize = 3),
			placeHolder = "Enter ID", 
			executor = @IMBeraExecutor(actions = {@Action(Executors = {PostExextutor.class}, type = ActionType.OnKeyUp)},
			postedExecutors = {PostExextutor.class},
			updatedExecutors = {PostExextutor.class})
	)
	private Integer employeeID;
	
	@Index(value = 1)
	@TextField(
			basicInfo = @IMBeraField(title = "cv cx v", colSize = 3),
			placeHolder = "Enter ID", 
			executor = @IMBeraExecutor(actions = {@Action(Executors = {PostExextutor.class}, type = ActionType.OnKeyUp)},
			postedExecutors = {PostExextutor.class},
			updatedExecutors = {PostExextutor.class})
	)
	private Integer employeeID2;
	
	@Index(value = 2)
	@CheckBox(
			basicInfo = @IMBeraField(title = "checkBoxs" , colSize = 3),
			options = @IMBeraOptions(values = {"111", "222", "333" }, valuesClass = GenderTitleMap.class),
			executor = @IMBeraExecutor(actions = {@Action(Executors = {PostExextutor.class}, type = ActionType.OnSelect)},postedExecutors = {PostExextutor.class},updatedExecutors = {PostExextutor.class}))
	private String checkBoxs;

	/*---------100 : 199 -------------*/
	@Index(value = 100)
	@Panel(basicInfo = @IMBeraField(title = "personalPanel"))
	private PersonalPanel personalPanel;

	/*@Index(value = 101)
	@Table(
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_personalTable, title = "personalTable")
	)
	private List<PersonalTableRow> personalTable;*/

	/*@Index(value = 102)
	@Tabs(
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_personalTable, title = "personalTable")
	)
	private PersonalTabs personalTabs;*/

	/*---------200 : 299 -------------*/
	@Index(value = 200)
	@Action(Executors = {}, title = "validateButton", type = ActionType.Button)
	private String validateButton;

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

	public PersonalPanel getPersonalPanel() {
		return personalPanel;
	}

	public void setPersonalPanel(PersonalPanel personalPanel) {
		this.personalPanel = personalPanel;
	}

	/*public List<PersonalTableRow> getPersonalTable() {
		return personalTable;
	}

	public void setPersonalTable(List<PersonalTableRow> personalTable) {
		this.personalTable = personalTable;
	}*/

	/*public PersonalTabs getPersonalTabs() {
		return personalTabs;
	}

	public void setPersonalTabs(PersonalTabs personalTabs) {
		this.personalTabs = personalTabs;
	}*/

	public String getValidateButton() {
		return validateButton;
	}

	public void setValidateButton(String validateButton) {
		this.validateButton = validateButton;
	}

	public Integer getEmployeeID2() {
		return employeeID2;
	}

	public void setEmployeeID2(Integer employeeID2) {
		this.employeeID2 = employeeID2;
	}
	
	
}
