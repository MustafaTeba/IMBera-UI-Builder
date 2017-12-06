package com.imbera.demo.executors.enums;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.imbera.demo.screen.PayRollForm;
import com.imbera.demo.screen.PersonalPanel;
import com.imbera.demo.screen.PersonalTab1;
import com.imbera.demo.screen.PersonalTab2;
import com.imbera.demo.screen.PersonalTableRow;
import com.imbera.demo.screen.PersonalTabs;
import com.imbera.demo.screen.UIContainer;

//TODO use enums info to Build Business Objects
public enum FieldsMap {
	PayRollForm_employeeID(PayRollForm.class,"employeeID"),
	PayRollForm_checkBoxs(PayRollForm.class,"checkBoxs"),
	/**/
	PayRollForm_personalPanel(PayRollForm.class,"personalPanel"),
	PayRollForm_personalTable(PayRollForm.class,"personalTable"),
	/**/
	PersonalPanel_employeeID(PersonalPanel.class,"employeeID"),
	PersonalPanel_checkBoxs(PersonalPanel.class,"checkBoxs"),
	/**/
	PersonalTableRow_employeeID(PersonalTableRow.class,"employeeID"),
	PersonalTableRow_checkBoxs(PersonalTableRow.class,"checkBoxs"),
	/**/
	PersonalTabs_personalTabs1(PersonalTabs.class,"personalTab1"),
	PersonalTabs_personalTabs2(PersonalTabs.class,"personalTab2"),
	/**/
	PersonalTab1_employeeID(PersonalTab1.class,"employeeID"),
	PersonalTab1_checkBoxs(PersonalTab1.class,"checkBoxs"),
	/**/
	PersonalTab2_employeeID(PersonalTab2.class,"employeeID"),
	PersonalTab2_checkBoxs(PersonalTab2.class,"checkBoxs")
	
	//**//
	//personalPanel(DemoForm2.class,"personalPanel")
	;
	
	Class<? extends UIContainer> clazz;
	Field field;
	private FieldsMap(Class<? extends UIContainer> clazz,String fieldName){
		this.clazz = clazz;
		try {
			this.field = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Class<? extends UIContainer> getClazz(){
		return clazz;
	}
	
	public Field getField(){
		return field;
	}
	
	@Override
	public String toString() {
		return field.getName();
	}
	
	private static Map<Integer, FieldsMap> map = new HashMap<Integer, FieldsMap>();
    static {
        for (FieldsMap fieldsMap : FieldsMap.values()) {
            // TODO set emuns order with random id
        	map.put(fieldsMap.ordinal(), fieldsMap);
        }
    }
    
    public static FieldsMap getEnumByID(int id) {
        return map.get(id);
    }
}
