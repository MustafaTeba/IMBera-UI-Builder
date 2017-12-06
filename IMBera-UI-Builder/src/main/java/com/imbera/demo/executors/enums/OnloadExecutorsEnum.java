package com.imbera.demo.executors.enums;

import java.util.HashMap;
import java.util.Map;

import com.imbera.demo.executors.OnLoadExecutor;
import com.imbera.demo.executors.formsOnLoad.InitExecutor;;

public enum OnloadExecutorsEnum implements OnLoadExecutor{
	
	onLoadExextutor {
		public Class<InitExecutor> getExecutorClass() {
			return InitExecutor.class;
		}
		
	};

	//
    private static Map<Integer, OnloadExecutorsEnum> map = new HashMap<Integer, OnloadExecutorsEnum>();
    static {
        for (OnloadExecutorsEnum executorsEnum : OnloadExecutorsEnum.values()) {
            // TODO set emuns order with random id
        	map.put(executorsEnum.ordinal(), executorsEnum);
        }
    }
    public static OnloadExecutorsEnum getEnumByID(int id) {
        return map.get(id);
    }
	
}
