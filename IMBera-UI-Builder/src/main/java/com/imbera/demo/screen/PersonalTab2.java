package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;

import io.imbera.ui.core.form.ComboBox;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.TabContainer;
import io.imbera.ui.core.form.TextField;

public class PersonalTab2  implements Serializable , TabContainer{

	private static final long serialVersionUID = -4515281198646980585L;

	@Index(1)
	@TextField(title = "Full Name",colSize = 3, placeHolder = "Enter ...", FieldsMap = FieldsMap.fullNameTab2, Executors = {ExecutorsEnum.FullNameKeyUpExextutor})
	private String fullName;

	@Index(2)
	@TextField(title = "Email",colSize = 3, pattern = "^\\S+@\\S+$", FieldsMap = FieldsMap.mailTab2, Executors = {})
	private String mail;
	
	@Index(3)
	@ComboBox(title = "Gender",colSize = 3, values = { "Male", "Female" }, Executors = {  }, FieldsMap = FieldsMap.genderTab2)
	private String gender;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}