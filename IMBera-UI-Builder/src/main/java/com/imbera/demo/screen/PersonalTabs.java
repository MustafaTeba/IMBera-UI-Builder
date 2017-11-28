package com.imbera.demo.screen;

import java.io.Serializable;

import io.imbera.ui.core.form.Tab;
import io.imbera.ui.core.form.TabContainer;
import io.imbera.ui.core.form.TabsContainer;

public class PersonalTabs  implements Serializable , TabsContainer{

	private static final long serialVersionUID = -4515281198646980585L;

	@Tab(index = 0, tabClass = PersonalTab1.class, title = "ssss")
	private TabContainer personalTab1;
	@Tab(index = 1, tabClass = PersonalTab2.class, title = "zzzz") 
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