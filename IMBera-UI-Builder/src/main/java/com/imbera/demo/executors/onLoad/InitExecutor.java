package com.imbera.demo.executors.onLoad;

import java.util.ArrayList;
import java.util.List;

import com.imbera.demo.executors.AbstractOnloadExecutor;
import com.imbera.demo.screen.PayRollForm;
import com.imbera.demo.screen.PersonalTab1;
import com.imbera.demo.screen.PersonalTableRow;
import com.imbera.demo.screen.PersonalTabs;

import io.imbera.ui.core.form.TableRowContainer;

public class InitExecutor extends AbstractOnloadExecutor{

	PayRollForm payRollForm;
	@Override
	public void doBussiness() {
		payRollForm = (PayRollForm) form ;
		payRollForm.setEmployeeID(10);
		
		PersonalTabs tabs = new PersonalTabs();
		PersonalTab1 tab1 = new PersonalTab1();
		//
		tabs.setPersonalTab1(tab1);
		tab1.setFullName("dddddddddddd");
		payRollForm.setPersonalTabs(tabs);
		//
		
		/*List<TableRowContainer> personalTable = new ArrayList<>();
		PersonalTableRow personalTableRow = new PersonalTableRow();
		personalTableRow.setFullName("Mostafa Teba");
		
		PersonalTableRow personalTableRow2 = new PersonalTableRow();
		personalTableRow2.setFullName("Mostafa Teba");
		
		PersonalTableRow personalTableRow3 = new PersonalTableRow();
		personalTableRow3.setFullName("Mostafa Teba");
		personalTableRow3.setGender("Male");
		
		PersonalTableRow personalTableRow4 = new PersonalTableRow();
		personalTableRow4.setFullName("Mostafa Teba");
		
		personalTable.add(personalTableRow);
		personalTable.add(personalTableRow2);
		personalTable.add(personalTableRow3);
		personalTable.add(personalTableRow4);
		
		payRollForm.setPersonalTable(personalTable);*/
		//
	}

	
}
