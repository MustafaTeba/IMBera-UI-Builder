package com.imbera.demo.executors.enums;

import java.util.HashMap;
import java.util.Map;

import com.imbera.demo.executors.FieldExecutor;
import com.imbera.demo.executors.fieldsExecutors.FullNameKeyUpExextutor;
import com.imbera.demo.executors.fieldsExecutors.PostExextutor;
import com.imbera.demo.executors.fieldsExecutors.SearchByIDExextutor;

public enum ExecutorsEnum implements FieldExecutor {
	
	PostExextutor {
		@Override
		public Class<PostExextutor> getExecutorClass() {
			return PostExextutor.class;
		}
		@Override
		public FieldsMap[] getFieldsToUpdate() {
			return new FieldsMap[] {FieldsMap.PayRollForm_employeeID};
		}
		@Override
		public FieldsMap[] getFieldsToPost() {
			return new FieldsMap[] {FieldsMap.PayRollForm_employeeID};
		}
		@Override
		public ExecutorType getExecutorType() {
			return ExecutorType.CLICK;
		}
	},
	FullNameKeyUpExextutor {
		@Override
		public Class<FullNameKeyUpExextutor> getExecutorClass() {
			return FullNameKeyUpExextutor.class;
		}
		@Override
		public FieldsMap[] getFieldsToUpdate() {
			return new FieldsMap[] {};
		}
		@Override
		public FieldsMap[] getFieldsToPost() {
			return new FieldsMap[] {};
		}
		@Override
		public ExecutorType getExecutorType() {
			return ExecutorType.KEYUP;
		}
	},
	SearchByIDExextutor {
		@Override
		public Class<SearchByIDExextutor> getExecutorClass() {
			return SearchByIDExextutor.class;
		}
		@Override
		public FieldsMap[] getFieldsToUpdate() {
			return new FieldsMap[] {};
		}
		@Override
		public FieldsMap[] getFieldsToPost() {
			return new FieldsMap[] {};
		}
		@Override
		public ExecutorType getExecutorType() {
			return ExecutorType.KEYUP;
		}
	};
	
	//
    private static Map<Integer, ExecutorsEnum> map = new HashMap<Integer, ExecutorsEnum>();
    static {
        for (ExecutorsEnum executorsEnum : ExecutorsEnum.values()) {
            // TODO set emuns order with random id
        	map.put(executorsEnum.ordinal(), executorsEnum);
        }
    }
    public static ExecutorsEnum getEnumByID(int id) {
        return map.get(id);
    }
	
}
