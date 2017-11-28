package com.imbera.demo.screen;

import java.io.Serializable;

import com.imbera.demo.enums.ExecutorsEnum;
import com.imbera.demo.enums.FieldsMap;

import io.imbera.ui.core.form.ComboBox;
import io.imbera.ui.core.form.Index;
import io.imbera.ui.core.form.TableRowContainer;
import io.imbera.ui.core.form.TextField;

public class PersonalTableRow  implements Serializable , TableRowContainer{

	private static final long serialVersionUID = -4515281198646980585L;

	@Index(1)
	@TextField(title = "Full Name",colSize = 3, placeHolder = "Enter ...", FieldsMap = FieldsMap.fullNameTable, Executors = {ExecutorsEnum.FullNameKeyUpExextutor})
	private String fullName;

	@Index(2)
	@TextField(title = "Email",colSize = 3, pattern = "^\\S+@\\S+$", FieldsMap = FieldsMap.mailTable, Executors = {})
	private String mail;
	
	@Index(3)
	@ComboBox(title = "Gender",colSize = 3, values = { "Male", "Female" }, Executors = {  }, FieldsMap = FieldsMap.genderTable)
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