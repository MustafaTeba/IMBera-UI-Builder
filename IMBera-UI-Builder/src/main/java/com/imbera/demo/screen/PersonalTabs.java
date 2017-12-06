package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.executors.enums.FieldsMap;

import io.imbera.ui.core.form.IMBeraField;
import io.imbera.ui.core.form.Tab;
import io.imbera.ui.core.form.TabContainer;
import io.imbera.ui.core.form.TabsContainer;

public class PersonalTabs  implements Serializable , TabsContainer{

	private static final long serialVersionUID = -4515281198646980585L;

	@Tab(basicInfo = @IMBeraField(FieldsMap = FieldsMap.PersonalTabs_personalTabs1, title = "personalTable"), tabClass = PersonalTab1.class)
	private TabContainer personalTab1;
	
	@Tab(basicInfo = @IMBeraField(FieldsMap = FieldsMap.PersonalTabs_personalTabs2, title = "personalTable"), tabClass = PersonalTab2.class)
	private TabContainer personalTab2;
	
	public TabContainer getPersonalTab1() {
		return personalTab1;
	}
	public void setPersonalTab1(TabContainer personalTab1) {
		this.personalTab1 = personalTab1;
	}
	public TabContainer getPersonalTab2() {
		return personalTab2;
	}
	public void setPersonalTab2(TabContainer personalTab2) {
		this.personalTab2 = personalTab2;
	}
	
	
}	