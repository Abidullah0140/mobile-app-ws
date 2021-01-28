package com.leaptechstudio.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class updateUserDetailsRequestModel {
	@NotNull(message = "First Name cannot be null")
	@Size(min = 8, message = "First name must not be less than 8 charecters")
	private String firstName;
	@NotNull(message = "Last Name cannot be null")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
