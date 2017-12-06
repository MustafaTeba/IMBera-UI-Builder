package com.imbera.demo.menu;

import java.io.Serializable;

import com.imbera.demo.executors.enums.UIFormsEnum;

import io.imbera.ui.core.enums.MenuType;
import io.imbera.ui.core.form.IMBeraMenuDef;
import io.imbera.ui.core.form.Menu;

@IMBeraMenuDef(title = "dddddddddd")
public class MainMenu implements Serializable , UIMenu{

	private static final long serialVersionUID = -3287807475213920864L;
	
	@Menu( name = "HOME", targetForm = UIFormsEnum.DemoForm , menuType = MenuType.CLASSIC , menuClass = HomeMenu.class)
	public static String home1;

	@Menu( name = "HOME2", targetForm = UIFormsEnum.DemoForm , menuType = MenuType.CLASSIC , menuClass = HomeMenu.class)
	public static String home2;
}
