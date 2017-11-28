package com.imbera.demo.enums;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.imbera.demo.screen.PayRollForm;
import com.imbera.demo.screen.PersonalPanel;
import com.imbera.demo.screen.PersonalTab1;
import com.imbera.demo.screen.PersonalTab2;
import com.imbera.demo.screen.PersonalTableRow;
import com.imbera.demo.screen.UIContainer;


//TODO use enums info to Build Business Objects
public enum FieldsMap {
	id(PayRollForm.class,"employeeID"),
	average(PayRollForm.class,"average"),
	password(PayRollForm.class,"password"),
	comment(PayRollForm.class,"comment"),
	/**/
	fullNamePanel(PersonalPanel.class,"fullName"),
	genderPanel(PersonalPanel.class,"gender"),
	mailPanel(PersonalPanel.class,"mail"),
	/**/
	
	fullNameTable(PersonalTableRow.class,"fullName"),
	genderTable(PersonalTableRow.class,"gender"),
	mailTable(PersonalTableRow.class,"mail"),
	
	/**/
	fullNameTab1(PersonalTab1.class,"fullName"),
	genderTab1(PersonalTab1.class,"gender"),
	mailTab1(PersonalTab1.class,"mail"),
	/**/
	fullNameTab2(PersonalTab2.class,"fullName"),
	genderTab2(PersonalTab2.class,"gender"),
	mailTab2(PersonalTab2.class,"mail")
	;
	
	Class<? extends UIContainer> clazz;
	String fieldName;
	
	private FieldsMap(Class<? extends UIContainer> clazz,String fieldName){
		this.clazz = clazz;
		try {
			Field field = clazz.getDeclaredField(fieldName);
			this.fieldName = field.getName();
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return fieldName;
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
