package com.imbera.demo.screen;

import java.io.Serializable;
import java.util.List;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;
import com.imbera.demo.executors.OnloadExecutorsEnum;

import io.imbera.ui.core.enums.ActionType;
import io.imbera.ui.core.form.Action;
import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.CheckBox;
import io.imbera.ui.core.form.IMBeraFormDef;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.Number;
import io.imbera.ui.core.form.Panel;
import io.imbera.ui.core.form.PanelContainer;
import io.imbera.ui.core.form.Password;
import io.imbera.ui.core.form.Table;
import io.imbera.ui.core.form.TableRowContainer;
import io.imbera.ui.core.form.Tabs;
import io.imbera.ui.core.form.TabsContainer;
import io.imbera.ui.core.form.TextArea;
import io.imbera.ui.core.form.TextField;

@IMBeraFormDef(title = "PayRoll", onLoadExecutors = { OnloadExecutorsEnum.onLoadExextutor }, 
	ActionsGroups = {
			@ActionsGroup(actions = {
					@Action(title = "InitExextutor", type = ActionType.Button , Executors = { }),
					@Action(title = "PostExextutor", type = ActionType.Button , Executors = { ExecutorsEnum.PostExextutor }),
					@Action(title = "JS Executor", type = ActionType.Button , onClick_Functions = "ValidateForm", Executors = {}) }) 
			}
		)
public class PayRollForm  implements Serializable , UIContainer {
	private  final long serialVersionUID = -1933740572277496405L;
	/*---------0 : 99 -------------*/
	@Index(value = 0)
	@TextField(title = "ID", colSize = 3, placeHolder = "Enter ID", FieldsMap = FieldsMap.id, Executors = {})
	private int employeeID;

	@Index(value = 1)
	@Number(title = "Average", colSize = 3, description = "This a double", Executors = {}, FieldsMap = FieldsMap.average)
	private String average;
	
	@Index(value = 1)
	@Number(title = "Average22", colSize = 3, description = "This a double", Executors = {}, FieldsMap = FieldsMap.average)
	private String average222;

	@Index(value = 2)
	@Password(title = "Password", colSize = 3, description = "Fill your password", Executors = {}, FieldsMap = FieldsMap.password)
	private String password;

	@Index(value = 3)
	@TextArea(title = "Comment", colSize = 9, description = "Add your Comment here", placeHolder = "fill your comment please", Executors = {}, FieldsMap = FieldsMap.comment)
	private String comment;

	@Index(value = 4)
	@CheckBox(title = "Comment", colSize = 9, values = { "AA" , "BB" , "CC" }, Executors = {}, FieldsMap = FieldsMap.comment)
	private String checkBoxs;

	/*---------100 : 199 -------------*/
	@Index(value = 100)
	@Panel(title = "PersonalPanel", panelClass = PersonalPanel.class)
	private PanelContainer personalPanel;

	
	@Index(value = 101)
	@Table(index = 0, title = "PersonalTable", rowClass = PersonalTableRow.class)
	private List<TableRowContainer> personalTable ;

	@Index(value = 102)
	@Tabs(index = 0, title = "PersonalPanel", tabsClass = PersonalTabs.class)
	private TabsContainer personalTabs;
	

	/*---------200 : 299 -------------*/
	@Index(value = 200)
	@Action(title = "validate email", type = ActionType.Button, Executors = {})
	private String validateButton;

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public String getAverage222() {
		return average222;
	}

	public void setAverage222(String average222) {
		this.average222 = average222;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
