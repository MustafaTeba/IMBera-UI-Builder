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

public class HomeMenu  implements Serializable , MenuContainer{

	private static final long serialVersionUID = -4874008738719793886L;

	@Menu( name = "vision",  targetForm = UIFormsEnum.DemoForm , menuType = MenuType.CLASSIC, menuClass = VisionMenu.class)
	public static String vision;
	@Menu( name = "mession",  targetForm = UIFormsEnum.DemoForm2 , menuType = MenuType.CLASSIC)
	public static String mession;
	@Menu( name = "about",  targetForm = UIFormsEnum.DemoForm , menuType = MenuType.CLASSIC)
	public static String about;
	@Menu( name = "overView",  targetForm = UIFormsEnum.DemoForm , menuType = MenuType.CLASSIC)
	public static String overView;
	
}