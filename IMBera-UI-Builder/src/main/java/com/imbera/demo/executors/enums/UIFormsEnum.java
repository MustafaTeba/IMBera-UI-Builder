package com.imbera.demo.executors.enums;

import java.util.HashMap;
import java.util.Map;

import com.imbera.demo.screen.PayRollForm;
import com.imbera.demo.screen.PayRollForm2;;

public enum UIFormsEnum {
	DemoForm(PayRollForm.class),
	DemoForm2(PayRollForm2.class);
	
	Class clazz;
	public Class getClazz() {
		return clazz;
	}
	private UIFormsEnum(Class<?> clazz){
		try {
			this.clazz = clazz;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return clazz.getName();
	}
	
	private static Map<Integer, UIFormsEnum> map = new HashMap<Integer, UIFormsEnum>();
    static {
        for (UIFormsEnum formsMap : UIFormsEnum.values()) {
            // TODO set emuns order with random id
        	map.put(formsMap.ordinal(), formsMap);
        }
    }
    
    public static UIFormsEnum getEnumByID(int id) {
        return map.get(id);
    }
}
