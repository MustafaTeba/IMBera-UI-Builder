package com.imbera.demo.screen;

import java.io.Serializable;
import java.util.List;

import com.imbera.demo.executors.enums.ExecutorsEnum;
import com.imbera.demo.executors.enums.FieldsMap;
import com.imbera.demo.executors.enums.OnloadExecutorsEnum;

import io.imbera.ui.core.enums.ActionType;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.CheckBox;
import io.imbera.ui.core.form.IMBeraField;
import io.imbera.ui.core.form.IMBeraFormDef;
import io.imbera.ui.core.form.IMBeraOptions;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.Panel;
import io.imbera.ui.core.form.PanelContainer;
import io.imbera.ui.core.form.Table;
import io.imbera.ui.core.form.TableRowContainer;
import io.imbera.ui.core.form.Tabs;
import io.imbera.ui.core.form.TabsContainer;
import io.imbera.ui.core.form.TextField;

@IMBeraFormDef(title = "PayRoll", onLoadExecutors = { OnloadExecutorsEnum.onLoadExextutor }, ActionsGroups = {
		@ActionsGroup(actions = { 
				@Action(title = "InitExextutor", type = ActionType.Button, Executors = {}),
				@Action(title = "PostExextutor", type = ActionType.Button, Executors = { ExecutorsEnum.PostExextutor }),
				@Action(title = "JS Executor", type = ActionType.Button, onClick_Functions = "ValidateForm", Executors = {}) 
				}) 
		}
)
public class PayRollForm implements Serializable, UIContainer {
	private final long serialVersionUID = -1933740572277496405L;
	/*---------0 : 99 -------------*/
	@Index(value = 0)
	@TextField(
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_employeeID, title = "employeeID", colSize = 3),
			placeHolder = "Enter ID",
			Executors = {}
	)
	private Integer employeeID;
	
	@Index(value = 1)
	@CheckBox(
			Executors = {},
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_checkBoxs, title = "checkBoxs" , colSize = 3),
			options = @IMBeraOptions(values = {"111", "222", "333" }, valuesClass = GenderTitleMap.class)
	)
	private String checkBoxs;

	/*---------100 : 199 -------------*/
	@Index(value = 100)
	@Panel(
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_personalPanel, title = "personalPanel"),
			panelClass = PersonalPanel.class
	)
	private PanelContainer personalPanel;

	@Index(value = 101)
	@Table(
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_personalTable, title = "personalTable"), 
			rowClass = PersonalTableRow.class
	)
	private List<TableRowContainer> personalTable;

	@Index(value = 102)
	@Tabs(
			basicInfo = @IMBeraField(FieldsMap = FieldsMap.PayRollForm_personalTable, title = "personalTable"), 
			tabsClass = PersonalTabs.class
	)
	private TabsContainer personalTabs;

	/*---------200 : 299 -------------*/
	@Index(value = 200)
	@Action(title = "validate email", type = ActionType.Button, Executors = {})
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

	public PanelContainer getPersonalPanel() {
		return personalPanel;
	}

	public void setPersonalPanel(PanelContainer personalPanel) {
		this.personalPanel = personalPanel;
	}

	public List<TableRowContainer> getPersonalTable() {
		return personalTable;
	}

	public void setPersonalTable(List<TableRowContainer> personalTable) {
		this.personalTable = personalTable;
	}

	public TabsContainer getPersonalTabs() {
		return personalTabs;
	}

	public void setPersonalTabs(TabsContainer personalTabs) {
		this.personalTabs = personalTabs;
	}

	public String getValidateButton() {
		return validateButton;
	}

	public void setValidateButton(String validateButton) {
		this.validateButton = validateButton;
	}

	
}
