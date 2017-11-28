package com.imbera.demo.menu;

import java.io.Serializable;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;
import com.imbera.demo.enums.UIFormsEnum;

import io.imbera.ui.core.enums.MenuType;
import io.imbera.ui.core.form.ComboBox;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.Menu;
import io.imbera.ui.core.form.MenuContainer;
import io.imbera.ui.core.form.PanelContainer;
import io.imbera.ui.core.form.Tab;
import io.imbera.ui.core.form.TextField;

public class VisionMenu  implements Serializable , MenuContainer{

	@Menu( name = "vision1",  targetForm = UIFormsEnum.DemoForm, menuType = MenuType.CLASSIC)
	public static String vision;
	
	@Menu( name = "vision2",  targetForm = UIFormsEnum.DemoForm, menuType = MenuType.CLASSIC)
	public static String vision2;
	
	@Menu( name = "vision3",  targetForm = UIFormsEnum.DemoForm, menuType = MenuType.CLASSIC)
	public static String vision3;
	
}