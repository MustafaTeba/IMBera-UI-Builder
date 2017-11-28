package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.enums.FieldsMap;

import io.imbera.ui.core.form.ActionsGroup;
import io.imbera.ui.core.form.IMBeraFormDef;
import io.imbera.ui.core.form.Panel;
import io.imbera.ui.core.form.PanelContainer;
import io.imbera.ui.core.form.Tab;
import io.imbera.ui.core.form.Tabs;
import io.imbera.ui.core.form.TextField;

@IMBeraFormDef(ActionsGroups = {}, onLoadExecutors = { }, title = "DDDDDDd")
public class DemoForm2 implements Serializable , UIContainer{
 
	private static final long serialVersionUID = -1933740572277496405L;

	@Panel(title = "PersonalPanel", panelClass = PersonalPanel.class)
	private PanelContainer personalPanel;

	public PanelContainer getPersonalPanel() {
		return personalPanel;
	}

	public void setPersonalPanel(PanelContainer personalPanel) {
		this.personalPanel = personalPanel;
	}
	
	
}
